package ru.synergy.kotlinpractice.drawerLayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import ru.synergy.kotlinpractice.databinding.ActivityDrawerLayoutBinding

class DrawerLayout : AppCompatActivity() {
    lateinit var binding: ActivityDrawerLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrawerLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            buttonOpen.setOnClickListener {
                drawer.openDrawer(GravityCompat.START)
            }
        }
    }
}