package ru.synergy.kotlinpractice.drawerLayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import ru.synergy.kotlinpractice.countDownTimer.CountDownTimer
import ru.synergy.kotlinpractice.databinding.ActivityDrawerLayoutBinding
import ru.synergy.kotlinpractice.navigationView.NavigationView

class DrawerLayout : AppCompatActivity() {
    lateinit var binding: ActivityDrawerLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrawerLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openPageTimer()

        binding.apply {

            buttonOpen.setOnClickListener {
                drawer.openDrawer(GravityCompat.START)
            }
        }

    }

    fun openNavView(view: View){
        binding.buttonOpenNavView.setOnClickListener {
            startActivity(Intent(this, NavigationView::class.java))
        }
    }

    fun openPageTimer() {
        binding.buttonPageTimer.setOnClickListener {
            startActivity(Intent(this, CountDownTimer::class.java))
        }
    }
}