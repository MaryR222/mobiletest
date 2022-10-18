package com.mobile.test.presentation.listCard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mobile.customcard.configView.ColorConfig
import com.mobile.customcard.configView.CustomCardConfig
import com.mobile.customcard.configView.CustomCardData
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
        (holder as? ListCardViewHolder)?.bind(card, position)
    }


   internal class ListCardViewHolder(private val binding: ItemListCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cardEntity: CardEntity, position: Int) {
            binding.apply {
                lContentItemCard.contentDescription = "Elemento del listado $position"
                customCard
                    .setConfig(CustomCardConfig(colors = ColorConfig()))
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