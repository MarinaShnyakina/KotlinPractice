package ru.synergy.kotlinpractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

// DATA CLASSES
//data class People(val name: String, var age: Int) {
//    override fun toString(): String {
//        return "Name $name, age $age"
//    }
//}

class People : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people)

    }

}


