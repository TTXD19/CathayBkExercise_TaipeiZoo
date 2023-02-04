package com.example.cathaybkexercise_taipeizoo.app.zone_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.cathaybkexercise_taipeizoo.databinding.FragmentTaipeiZooZoneListBinding
import com.example.data.repository.taipei_zoo.ITaipeiZooRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class TaipeiZooZoneListFragment: Fragment(), TaipeiZooZoneListContracts.View{

    @Inject
    lateinit var taipeiZooRepository: ITaipeiZooRepository

    private lateinit var binding: FragmentTaipeiZooZoneListBinding

    private val presenter: TaipeiZooZoneListPresenter by lazy {
        TaipeiZooZoneListPresenter(this, taipeiZooRepository)
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