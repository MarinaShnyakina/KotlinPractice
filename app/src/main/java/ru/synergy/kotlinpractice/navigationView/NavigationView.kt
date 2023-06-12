package ru.synergy.kotlinpractice.navigationView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.GravityCompat
import ru.synergy.kotlinpractice.R
import ru.synergy.kotlinpractice.databinding.ActivityNavigationViewBinding

class NavigationView : AppCompatActivity() {
    lateinit var binding: ActivityNavigationViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            buttonOpen.setOnClickListener {
                drawer.openDrawer(GravityCompat.START)
            }

            navView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.item1 -> {
                        Toast.makeText(this@NavigationView, "Item 1", Toast.LENGTH_SHORT).show()
                    }
                    R.id.item2 -> Toast.makeText(this@NavigationView, "Item 2", Toast.LENGTH_SHORT).show()
                }
                /* можно закрыть, нажимая любую кнопку
                drawer.closeDrawer(GravityCompat.START)
                */

                true
            }


        }
    }
}