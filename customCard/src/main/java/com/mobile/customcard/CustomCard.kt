package com.mobile.customcard

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.AccessibilityDelegateCompat
import androidx.core.view.ViewCompat
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat
import com.mobile.customcard.configView.CardStyle
import com.mobile.customcard.configView.Coin
import com.mobile.customcard.configView.CustomCardConfig
import com.mobile.customcard.configView.CustomCardData
import com.mobile.customcard.databinding.CustomCardLayoutBinding
import com.mobile.customcard.utils.animProgress
import com.mobile.customcard.utils.format
import com.mobile.customcard.utils.setStyle
import com.mobile.customcard.utils.show


class CustomCard @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attributeSet, defStyleAttr) {

    private var binding: CustomCardLayoutBinding =
        CustomCardLayoutBinding.inflate(LayoutInflater.from(context), this, true)

    private var showCardControl: Boolean = true
    private var showMoreOptions: Boolean = true
    private var showImagenCard: Boolean = true
    private var showLastNumberCard: Boolean = true
    private var cardActive: Boolean = true
    private var coinType: Coin = Coin.EURO
    private var config: CustomCardConfig? = null
    private var style: CardStyle? = null
    private var data: CustomCardData? = null

    init {
        attributeSet?.let {
            val typeArray = context.obtainStyledAttributes(it, R.styleable.CustomCard, 0, 0)
            val coin = typeArray.getEnum(R.styleable.CustomCard_coinType, Coin.EURO)
            showCardControl = typeArray.getBoolean(R.styleable.CustomCard_showCardControl, true)
            showImagenCard = typeArray.getBoolean(R.styleable.CustomCard_showImagenCard, true)
            showLastNumberCard =
                typeArray.getBoolean(R.styleable.CustomCard_showLastNumberCard, true)
            showMoreOptions = typeArray.getBoolean(R.styleable.CustomCard_showMoreOptions, true)
            cardActive = typeArray.getBoolean(R.styleable.CustomCard_cardActive, true)
            coinType = coin
            typeArray.recycle()
        }
    }

    private inline fun <reified T : Enum<T>> TypedArray.getEnum(index: Int, default: T) =
        getInt(index, -1).let {
            if (it >= 0) enumValues<T>()[it] else default
        }

    fun setConfig(customConfig: CustomCardConfig): CustomCard {
        config = customConfig
        config?.let { it ->
            this.style = CardStyle(it.fonts, it.colors)
        }
        return this
    }

    fun setData(customCardData: CustomCardData): CustomCard {
        data = customCardData
        return this
    }

    fun build() {
        super.onAttachedToWindow()
        loadView()
    }

    @SuppressLint("SetTextI18n")
    private fun loadView() {
        binding.apply {
            setStyle(style)
            clContentControl.show(showCardControl)
            ivDots.show(showMoreOptions)
            clContentCard.show(showImagenCard)
            clContenBottom.show(cardActive)
            tvCreditLastNumber.show(showLastNumberCard)

            data?.let { data ->

                progress.animProgress(to = data.percentage.toInt())

                typeCard.text = data.typeCard
                tvCreditMont.text = data.credit.toString().plus(coinType.typeCoin)
                tvCreditDebtAmount.text = data.creditDebt.toString().plus(coinType.typeCoin)
                tvCreditEnableAmount.text = data.creditEnable.toString().plus(coinType.typeCoin)
                lCard.tvClientName.text = data.clientName
                lCard.tvPan.text = data.pan
                lCard.tvHolderType.text = data.typeOwnership
                stateCard.isChecked = data.activeCard
                tvCredit.text = data.typeCard?.split(" ")?.get(0)?.uppercase() ?: ""
                tvCreditLastNumber.text = "..".plus(data.lastNumberCard)
                tvCreditHolder.text = data.typeOwnership?.uppercase()
                val cardStateString =
                    if (stateCard.isChecked) context.getString(R.string.accesibility_action_card_status) else context.getString(
                        R.string.accesibility_action_card_status_deactivated
                    )
                clHeader.contentDescription = context.getString(
                    R.string.accessibility_description_header_custom_card,
                    data.typeCard,
                    data.lastNumberCard,
                    data.typeOwnership
                )

                clInfoEconomy.contentDescription = context.getString(
                    R.string.accessibility_description_info_custom_card,
                    data.creditDebt.format(),
                    data.creditEnable.format()
                )

                clContentProgress.contentDescription = context.getString(
                    R.string.accessibility_description_progress_custom_card,
                    data.credit.format(),
                )
                clContenBottom.contentDescription = context.getString(
                    R.string.accessibility_description_status_custom_card,
                    cardStateString,
                )

                ViewCompat.setAccessibilityDelegate(
                    clContentControl,
                    object : AccessibilityDelegateCompat() {
                        override fun onInitializeAccessibilityNodeInfo(
                            v: View,
                            info: AccessibilityNodeInfoCompat
                        ) {
                            super.onInitializeAccessibilityNodeInfo(v, info)
                            info.addAction(
                                AccessibilityNodeInfoCompat.AccessibilityActionCompat(
                                    AccessibilityNodeInfoCompat.ACTION_CLICK,
                                    context.getString(R.string.accesibility_action_card_control)
                                )
                            )
                        }
                    })
            }
        }
    }
}

