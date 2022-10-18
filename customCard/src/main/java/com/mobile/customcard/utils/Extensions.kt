package com.mobile.customcard.utils

import android.content.res.ColorStateList
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.mobile.customcard.R
import com.mobile.customcard.configView.CardStyle
import com.mobile.customcard.configView.Coin
import com.mobile.customcard.databinding.CustomCardLayoutBinding

fun View.show(showed: Boolean = true) {
    if (showed)
        this.visibility = View.VISIBLE
    else
        this.visibility = View.GONE
}

fun CustomCardLayoutBinding.setStyle(style: CardStyle?) {
    style?.let {
        it.colors?.let { colors ->
            colors.colorTextTitle?.let { titleColor ->
                tvCredit.setTextColor(ContextCompat.getColor(root.context, titleColor))
                tvCreditLimit.setTextColor(ContextCompat.getColor(root.context, titleColor))
                tvCreditMont.setTextColor(ContextCompat.getColor(root.context, titleColor))
                tvCreditDebt.setTextColor(ContextCompat.getColor(root.context, titleColor))
                typeCard.setTextColor(ContextCompat.getColor(root.context, titleColor))
                stateCard.setTextColor(ContextCompat.getColor(root.context, titleColor))

                tvCreditEnable.setTextColor(
                    ContextCompat.getColor(
                        root.context,
                        titleColor
                    )
                )
                tvCreditDebtAmount.setTextColor(
                    ContextCompat.getColor(
                        root.context,
                        titleColor
                    )
                )
                tvCreditEnableAmount.setTextColor(
                    ContextCompat.getColor(
                        root.context,
                        titleColor
                    )
                )
                stateCard.setTextColor(ContextCompat.getColor(root.context, titleColor))
            }
            colors.colorControl?.let { controlColor ->
                tvCardControl.setTextColor(ContextCompat.getColor(root.context, controlColor))
                ivSettings.backgroundTintList = ColorStateList.valueOf(controlColor)
            }

            colors.colorProgress?.let { colorProgress ->
                DrawableCompat.setTint(
                    progress.indeterminateDrawable,
                    ContextCompat.getColor(root.context, colorProgress)
                )

                DrawableCompat.setTint(
                    circleShapeDebt.drawable,
                    ContextCompat.getColor(root.context, colorProgress)
                )

                DrawableCompat.setTint(
                    circleShapeEnable.drawable,
                    ContextCompat.getColor(root.context, R.color.lightGrey)
                )
            }
        }
    }
}