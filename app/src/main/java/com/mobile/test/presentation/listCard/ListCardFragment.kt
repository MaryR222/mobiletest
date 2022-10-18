package com.mobile.test.presentation.listCard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.mobile.customcard.utils.show
import com.mobile.test.databinding.FragmentListCardBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class ListCardFragment : Fragment() {
    lateinit var binding: FragmentListCardBinding


    private val viewModel: ListCardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListCardBinding.inflate(LayoutInflater.from(context))
        return binding.root
    }

    private fun initViewModel() {

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect(::updateUi)
            }
        }
    }

    private fun updateUi(state: UiState) {

        binding.apply {
            progressBar.show(state.loading)

            if (state.cards?.list?.isNotEmpty() == true) {
                rvCardList.layoutManager =
                    LinearLayoutManager(root.context, LinearLayoutManager.HORIZONTAL, false)
                rvCardList.adapter = ListCardAdapter()
                (rvCardList.adapter as? ListCardAdapter?)?.submitList(state.cards.list)
            }
        }

    }

}