package com.contreras.poketinder.ui.view


import android.os.Bundle



import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.contreras.poketinder.R
import com.contreras.poketinder.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yuyakaido.android.cardstackview.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navView:BottomNavigationView= binding.navView

        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)
    }

}
