package ru.synergy.kotlinpractice.youtuber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.synergy.kotlinpractice.databinding.ActivityYoutuberBinding

class Youtuber : AppCompatActivity() {
    lateinit var bindingClass: ActivityYoutuberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityYoutuberBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)


        bindingClass.buttonResult.setOnClickListener{

            val resultValue = bindingClass.editTextValue.text.toString().toInt()

            when(resultValue) {

                in 0..1000 -> {
                   // bindingClass.textViewResult.visibility = View.VISIBLE
                    bindingClass.textViewResult.text = "Вы начинающий блогер!"
                }
                in 1000..100_000 -> {
                   // bindingClass.textViewResult.visibility = View.VISIBLE
                    bindingClass.textViewResult.text = "Вы средний блогер!"
                }
                    else -> {
                      //  bindingClass.textViewResult.visibility = View.VISIBLE
                        bindingClass.textViewResult.text = "Вы крупный блогер!!"

                    }

            }
        }


    }

}