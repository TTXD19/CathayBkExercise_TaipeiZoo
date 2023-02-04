package com.example.cathaybkexercise_taipeizoo.app.zone_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.cathaybkexercise_taipeizoo.BaseFragment
import com.example.cathaybkexercise_taipeizoo.databinding.FragmentTaipeiZooZoneListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TaipeiZooZoneListFragment: BaseFragment(), TaipeiZooZoneListContracts.View{

    private lateinit var binding: FragmentTaipeiZooZoneListBinding
    private val presenter: TaipeiZooZoneListPresenter by lazy {
        TaipeiZooZoneListPresenter(this)
    }

    companion object{
        fun newInstance(): TaipeiZooZoneListFragment{
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

        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO){
            presenter.fetchTaipeiZooZoneList()
        }
    }

    override fun onTaipeiZooZoneListUpdate() {

    }
}