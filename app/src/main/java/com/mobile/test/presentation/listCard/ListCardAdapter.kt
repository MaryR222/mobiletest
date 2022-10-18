package com.mobile.test.presentation.listCard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mobile.customcard.configView.ColorConfig
import com.mobile.customcard.configView.CustomCardConfig
import com.mobile.customcard.configView.CustomCardData
import com.mobile.customcard.configView.FontConfig
import com.mobile.test.R
import com.mobile.test.databinding.ItemListCardBinding

internal class ListCardAdapter(
) : ListAdapter<CardEntity, RecyclerView.ViewHolder>(ListCardDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ListCardViewHolder(
            binding = ItemListCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val card = getItem(position)
        (holder as? ListCardViewHolder)?.bind(card, position + 1)
    }


    inner class ListCardViewHolder(private val binding: ItemListCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cardEntity: CardEntity, position: Int) {
            binding.apply {
                customCard
                    .setConfig(
                        CustomCardConfig(
                            colors = ColorConfig(),
                            fonts = FontConfig(
                                titles = ResourcesCompat.getFont(
                                    root.context,
                                    R.font.test_mobile_font
                                )
                            )
                        )
                    )
                    .setData(
                        CustomCardData(
                            credit = cardEntity.creditLimit,
                            creditEnable = cardEntity.creditEnable,
                            creditDebt = cardEntity.creditDebt,
                            activeCard = cardEntity.activeCard,
                            typeCard = cardEntity.typeCard,
                            percentage = cardEntity.percentage,
                            typeOwnership = cardEntity.holderType,
                            clientName = cardEntity.clientName,
                            pan = cardEntity.pan,
                            lastNumberCard = cardEntity.lastNumber

                        )
                    )
                    .build()
                lContentItemCard.contentDescription = root.context.getString(
                    R.string.accessibility_description_list,
                    position,
                    cardEntity.lastNumber
                )

            }
        }
    }

    internal class ListCardDiffUtil : DiffUtil.ItemCallback<CardEntity>() {
        override fun areItemsTheSame(
            oldItem: CardEntity,
            newItem: CardEntity
        ): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: CardEntity,
            newItem: CardEntity
        ): Boolean =
            oldItem.id == newItem.id
    }

}