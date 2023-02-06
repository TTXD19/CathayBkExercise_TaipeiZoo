package com.example.cathaybkexercise_taipeizoo.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.cathaybkexercise_taipeizoo.R
import com.example.cathaybkexercise_taipeizoo.app.zone_detail.TaipeiZoneDetailFragment
import com.example.cathaybkexercise_taipeizoo.app.zone_list.TaipeiZooZoneListFragment
import com.example.cathaybkexercise_taipeizoo.databinding.ActivityMainBinding
import com.example.model.taipei_zoo.ZooZoneDetail
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), TaipeiZooActivityHandler {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        goTaipeiZooZoneList()
    }

    override fun goTaipeiZooZoneList() {
        supportFragmentManager.commit {
            replace(R.id.frame_layout, TaipeiZooZoneListFragment.newInstance())
            setReorderingAllowed(true)
            addToBackStack("Test")
        }
    }

    override fun goTaipeiZooZoneDetail(zooZoneDetail: ZooZoneDetail) {
        supportFragmentManager.commit {
            replace(R.id.frame_layout, TaipeiZoneDetailFragment.newInstance(zooZoneDetail))
            setReorderingAllowed(true)
            addToBackStack("name") // name can be null
        }
    }

    override fun onBackPressed() {
        val currentFragment = supportFragmentManager.fragments[1]
        if (currentFragment is TaipeiZoneDetailFragment) {
            supportFragmentManager.popBackStack(null, 0)
        }
//        onBackPressedDispatcher.onBackPressed()
    }
}