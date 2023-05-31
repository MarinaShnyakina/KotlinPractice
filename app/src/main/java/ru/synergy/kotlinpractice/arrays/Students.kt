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

        for ((index, grade) in gradeArray.withIndex()) {
            when (grade) {
                in bad -> badArray.add("Плохие оценки: Ученик: ${nameArray[index]} - $grade")
                in normal -> normalArray.add("Нормальные оценки: Ученик: ${nameArray[index]} - $grade")
                in nice -> niceArray.add("Хорошие оценки: Ученик: ${nameArray[index]} - $grade")
                great -> greatArray.add("Отличные оценки: Ученик: ${nameArray[index]} - $grade")
            }

            badArray.forEach {Log.d("Log", it)}
            normalArray.forEach {Log.d("Log", it)}
            niceArray.forEach {Log.d("Log", it)}
            greatArray.forEach {Log.d("Log", it)}
        }
    }
}