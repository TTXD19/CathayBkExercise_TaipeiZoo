package com.example.cathaybkexercise_taipeizoo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cathaybkexercise_taipeizoo.app.zone_list.TaipeiZooZoneListFragment
import com.example.cathaybkexercise_taipeizoo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.frame_layout, TaipeiZooZoneListFragment.newInstance()).commit()
    }
}