package ru.synergy.kotlinpractice.arrays

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.synergy.kotlinpractice.R

class Business : AppCompatActivity() {
    val investArray = arrayOf(10000, 2300, 45000, 65000, 6500, 400)
    val earnArray = arrayOf(15000, 300, 325000, 5000, 13600, 3700)
    val resultArray = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val names = resources.getStringArray(R.array.names)

        for ((index, name) in names.withIndex()) {

            resultArray.add("Имя: $name - прибыль = ${earnArray[index] - investArray[index]}")
            Log.d("Log", "Статистика -/- ${resultArray[index]}")
        }
    }
}

