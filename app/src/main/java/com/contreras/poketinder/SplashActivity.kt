package com.contreras.poketinder
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.AlarmClock
import androidx.appcompat.app.AppCompatActivity


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val intent=Intent(this, MainActivity::class.java).apply{
            putExtra(AlarmClock.EXTRA_MESSAGE,"message")
        }
        Handler(Looper.getMainLooper()).postDelayed({startActivity(intent);finish()},3000)
    }
}
