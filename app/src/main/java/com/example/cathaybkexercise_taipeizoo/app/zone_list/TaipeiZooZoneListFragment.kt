package com.example.cathaybkexercise_taipeizoo.app.zone_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.cathaybkexercise_taipeizoo.BaseFragment
import com.example.cathaybkexercise_taipeizoo.app.TaipeiZooActivityHandler
import com.example.cathaybkexercise_taipeizoo.databinding.FragmentTaipeiZooZoneListBinding
import com.example.model.taipei_zoo.TaipeiZooResp
import com.example.model.taipei_zoo.ZooZoneDetail
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TaipeiZooZoneListFragment : BaseFragment(), TaipeiZooZoneListContracts.View {

    private lateinit var binding: FragmentTaipeiZooZoneListBinding
    private val presenter: TaipeiZooZoneListPresenter by lazy { TaipeiZooZoneListPresenter(this) }

    private val onItemClickCallBack: (((ZooZoneDetail) -> Unit)) = {
        getActivityHandler(TaipeiZooActivityHandler::class.java)?.goTaipeiZooZoneDetail(it)
    }

    private val taipeiZooZoneListAdapter: TaipeiZooZoneListAdapter by lazy {
        TaipeiZooZoneListAdapter(onItemClickCallBack)
    }

    companion object {
        fun newInstance(): TaipeiZooZoneListFragment {
            return TaipeiZooZoneListFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaipeiZooZoneListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getActivityHandler(TaipeiZooActivityHandler::class.java)?.setToolbarAsZooZoneListUse()
        initView()
        initListener()
        callZooListData()
    }

    private fun initView() {
        binding.rvZooZone.adapter = taipeiZooZoneListAdapter
    }

    private fun initListener() {
        binding.btnRetryMessage.setOnClickListener {
            callZooListData()
        }
    }

    private fun callZooListData() {
        binding.groupRetry.isVisible = false
        binding.progress.isVisible = true
        binding.rvZooZone.isVisible = false
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            presenter.fetchTaipeiZooZoneList()
        }
    }

    override fun onTaipeiZooZoneListUpdate(taipeiZooResp: TaipeiZooResp) {
        taipeiZooZoneListAdapter.submitList(taipeiZooResp.results)
        binding.groupRetry.isVisible = false
        binding.progress.isVisible = false
        binding.rvZooZone.isVisible = true
    }

    override fun onTaipeiZooZoneListUpdateFailed() {
        binding.groupRetry.isVisible = true
        binding.progress.isVisible = false
        binding.rvZooZone.isVisible = false
    }
}