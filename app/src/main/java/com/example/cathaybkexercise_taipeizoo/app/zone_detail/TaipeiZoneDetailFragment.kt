package com.example.cathaybkexercise_taipeizoo.app.zone_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.cathaybkexercise_taipeizoo.BaseFragment
import com.example.cathaybkexercise_taipeizoo.databinding.FragmentTaipeiZooZoneDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TaipeiZoneDetailFragment : BaseFragment(), TaipeiZoneDetailContracts.View {

    private lateinit var binding: FragmentTaipeiZooZoneDetailBinding
    private val presenter: TaipeiZoneDetailPresenter by lazy { TaipeiZoneDetailPresenter(this) }

    companion object{
        fun newInstance(): TaipeiZoneDetailFragment{
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

        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO){
            presenter.fetchZoneDetail()
        }
    }


    override fun onZoneDetailUpdate() {

    }
}