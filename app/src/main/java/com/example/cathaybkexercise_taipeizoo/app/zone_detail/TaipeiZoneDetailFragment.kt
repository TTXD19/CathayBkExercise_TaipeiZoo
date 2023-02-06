package com.example.cathaybkexercise_taipeizoo.app.zone_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.cathaybkexercise_taipeizoo.BaseFragment
import com.example.cathaybkexercise_taipeizoo.databinding.FragmentTaipeiZooZoneDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TaipeiZoneDetailFragment : BaseFragment(), TaipeiZoneDetailContracts.View {

    private lateinit var binding: FragmentTaipeiZooZoneDetailBinding
    private val taipeiPlantDetailAdapter: TaipeiPlantDetailAdapter by lazy { TaipeiPlantDetailAdapter() }

    companion object {
        fun newInstance(): TaipeiZoneDetailFragment {
            return TaipeiZoneDetailFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaipeiZooZoneDetailBinding.inflate(inflater, container, false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val plantFlow = Pager(PagingConfig(pageSize = 20, prefetchDistance = 5)) {
            TaipeiPlantPagingSource(requireContext())
        }.flow.cachedIn(viewLifecycleOwner.lifecycleScope)

        viewLifecycleOwner.lifecycleScope.launch {
            plantFlow.collectLatest { pagingData ->
                taipeiPlantDetailAdapter.submitData(pagingData)
            }
        }

        binding.rvPlantDetails.adapter = taipeiPlantDetailAdapter
    }

    override fun onZoneDetailUpdate() {

    }
}