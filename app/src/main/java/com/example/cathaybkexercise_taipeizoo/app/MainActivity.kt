package com.example.cathaybkexercise_taipeizoo.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.commit
import com.example.cathaybkexercise_taipeizoo.R
import com.example.cathaybkexercise_taipeizoo.app.plant_detail.PlantDetailFragment
import com.example.cathaybkexercise_taipeizoo.app.zone_detail.TaipeiZoneDetailFragment
import com.example.cathaybkexercise_taipeizoo.app.zone_list.TaipeiZooZoneListFragment
import com.example.cathaybkexercise_taipeizoo.databinding.ActivityMainBinding
import com.example.model.taipei_zoo.PlantDetail
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
            addToBackStack(null)
        }
    }

    override fun goTaipeiZooZoneDetail(zooZoneDetail: ZooZoneDetail) {
        supportFragmentManager.commit {
            setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
            replace(R.id.frame_layout, TaipeiZoneDetailFragment.newInstance(zooZoneDetail))
            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }

    override fun goPlantDetail(plantDetail: PlantDetail) {
        supportFragmentManager.commit {
            setCustomAnimations(R.anim.slide_in, R.anim.fade_out, R.anim.fade_in, R.anim.slide_out)
            replace(R.id.frame_layout, PlantDetailFragment.newInstance(plantDetail))
            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }

    override fun setToolbarAsZooZoneListUse() {
        binding.apply {
            imageBackArrow.isVisible = false
            tvTitle.text = getString(R.string.taipei_zoo)
        }
    }

    override fun setToolbarAsZooZoneDetailUse() {
        binding.apply {
            imageBackArrow.isVisible = true
            imageBackArrow.setOnClickListener {
                supportFragmentManager.popBackStack(null, 0)
            }
            tvTitle.text = getString(R.string.zoo_zone_info)
        }
    }

    override fun setToolbarAsPlantDetailUse() {
        binding.apply {
            imageBackArrow.isVisible = true
            imageBackArrow.setOnClickListener {
                supportFragmentManager.popBackStack(null, 0)
            }
            tvTitle.text = getString(R.string.plant_detail)
        }
    }

    override fun onBackPressed() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.frame_layout)
        if (currentFragment is TaipeiZooZoneListFragment) showLeaveDialog()
        else supportFragmentManager.popBackStack(null, 0)
    }

    private fun showLeaveDialog() {
        AlertDialog.Builder(this)
            .setTitle(R.string.leave_title)
            .setMessage(R.string.leave_message)
            .setPositiveButton(R.string.leave_confirm) { _, _ -> finish() }
            .setNegativeButton(R.string.leave_cancel) { dialog, _ -> dialog.dismiss() }
            .create()
            .show()
    }
}