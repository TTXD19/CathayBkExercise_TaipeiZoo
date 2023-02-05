package com.example.cathaybkexercise_taipeizoo.app.zone_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cathaybkexercise_taipeizoo.app.zone_list.TaipeiZooZoneListFragment

class TaipeiZoneDetailFragment : Fragment(), TaipeiZoneDetailContracts.View {

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
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onZoneDetailUpdate() {
        TODO("Not yet implemented")
    }
}