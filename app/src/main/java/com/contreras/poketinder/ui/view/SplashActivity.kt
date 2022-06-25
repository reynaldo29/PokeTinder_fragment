package com.contreras.poketinder.ui.view
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.viewModels
import com.contreras.poketinder.databinding.ActivitySplashBinding
import com.contreras.poketinder.ui.viewmodel.SplashViewModel
import com.contreras.poketinder.util.SharedPreferenceUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate){

    private lateinit var sharedPreferenceUtil:SharedPreferenceUtil
    private val splashViewModel : SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(this)
        }

        splashViewModel.getIsUnderMaintance().observe(this) {
            if (it) {
                Toast.makeText(this, "bajo mantenimiento", Toast.LENGTH_SHORT).show()

            } else {
                showAnimation()
            }
        }
    }
        //SE PROGRAMA EL TIEMPO DE DURACIÓN DEL SPLASH ANTES DE PASAR AL MAIN ACTIVITY

        fun showAnimation(){
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    //Evaluar si mostrar o no
                    val isIntroAvailable = sharedPreferenceUtil.getIntroShow()
                    if (!isIntroAvailable) {
                        startActivity(Intent(this, OnboardingActivity::class.java))
                    } else {
                        startActivity(Intent(this, LoginActivity::class.java))
                    }
                    finish()
                },
                3000
            )

        }
}