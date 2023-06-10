package ru.synergy.kotlinpractice.arrays

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class Students {
    val bad = 0..3
    val normal = 4..6
    val nice = 7..9
    val great = 10
    val gradeArray = arrayOf(4, 7, 3, 6, 10, 2)
    val nameArray = arrayOf("Marina", "Katy", "Anton", "Sveta", "Anna", "Grisha")
    val badArray = ArrayList<String>()
    val normalArray = ArrayList<String>()
    val niceArray = ArrayList<String>()
    val greatArray = ArrayList<String>()

    fun rating() {

        for ((index,name) in nameArray.withIndex()) {
            when (gradeArray[index]) {
                in bad -> badArray.add("Плохие оценки: Ученик: $name - ${gradeArray[index]}")
                in normal -> normalArray.add("Нормальные оценки: Ученик: $name - ${gradeArray[index]}")
                in nice -> niceArray.add("Хорошие оценки: Ученик: $name - ${gradeArray[index]}")
                great -> greatArray.add("Отличные оценки: Ученик: $name - ${gradeArray[index]}")
            }
        }

        badArray.forEach { Log.d("Log", it) }
        normalArray.forEach { Log.d("Log", it) }
        niceArray.forEach { Log.d("Log", it) }
        greatArray.forEach { Log.d("Log", it) }
    }
}