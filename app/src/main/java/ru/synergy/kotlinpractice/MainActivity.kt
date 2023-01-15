package ru.synergy.kotlinpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    /* БЛОК ПЕРЕМЕННЫЕ
    * val | var имя_переменной: тип_переменной
    * var - изменяемая переменная = mutable collection - изменяемая коллекция
    * val - неизменяемая переменная (final) = immutable collection - пересоздаваемая коллекция
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val age: Int
        //age = 23
        val age: Int = 23
        println(age)

        /* ТИПЫ ДАННЫХ
        * Базовые типы:
        * 1. Числовые типы (числа):
        * 1.1 Целочисленные - Byte, Short, Int, Long
        * 1.2 Типы с плавающей точкой - Float (одинарная точность - 32 бита), Double (двойная точность - 64 бита)
        * 2. Логический тип - Boolean
        * 3. Символьный тип - Char
        * 4. Строчный тип - String
        * 5. Массив - Array
        *
        * Any - супертип всех типов, не допускающих значение null
        */

        val firstName: String = "Marina"
        val secondName: String = "Shnyakina"
        val welcome: String = "Hello $firstName $secondName"
        println(welcome)


        // ЛОГИЧЕСКИЕ ВЫРАЖЕНИЯ

        val a = true
        val b = false
        var c = a and b  // a && b на Java
        c = a or b  // a || b на Java
        c = a xor b  // сравнение двух значений (одинаковые - 0, разные - 1)
        c = a.not()  // !a на Java

        val d = 5
        val e = d in 1..6

        if (a == b) d else e

        /* SWITCH CASE
        * when(объект) {
        * значение1 -> действие1
        * значение2 -> действие2
        * значение3 -> действие3
        *
        * }
         */

        /*val isEnable = true
        when (isEnable) {
            true -> println("isEnable oh")
            false -> println("isEnable off")
        }*/

        val param = 10
        when (param) {
            in 1..10 -> println("isEnable oh")
            11, 12 -> println("isEnable off")
            else -> println("Undefined variable")
        }

        val firstArg = 15
        val secondArg = 6
        when {
            (firstArg > 10) -> println("FirstArg больше 10") // либо можно указать, чтобы вернулась переменная
            (secondArg > 10) -> println("Second больше 10")
            else -> println("First и Second больше 10")
        }

        for (n in 1..9) {
            println("${n*n} \t")
        }


        // ПОСЛЕДОВАТЕЛЬНОСТЬ

/*        var range: Any = 1..5 // [1,2,3,4,5]
        range = "a".."d"

        range = 5 downTo 1   // [5,4,3,2,1]
        range = 5 downTo 1 step 2   // [5,3,1]
        range = 1 until 9   // [1,2,3,4,5,6,7,8]
        range = 2 in 1 until 9 step 2   // false*/

        // перебирание range
        for ( c in 1..9) println(c)

        // МАССИВЫ

        val numbers: Array<Int> = arrayOf(1,2,3,4,5,6) // arrayOf - позволяет собрать массив
        val n = numbers[1]
        numbers[3] = 7
        println("Numbers[2] = ${numbers[2]}") // по сути {numbers[2]} - я вляется Лямбда выражением


        // val numbers2 = Array(3, {5}) // [5,5,5]
        // var i = 1
        // var numbers2 = Array(3) { i++ * 2 } // [2,4,8]

        for (number in numbers) print("%number \t") // тут in - оператор проверки вхождения

        val people = arrayOf("Marina", "Katya", "Semen")
        for (person in people)
            print("$person \t")

        var i = 0
        while (i in people.indices) {
            print("${people[i]} \t")
            i++
        }

        for (i in people.indices) {
            print("${people[i]} \t")
        }

        var integers: IntArray = intArrayOf(1,2,3,4,5,6)
        var doubles: DoubleArray = doubleArrayOf(1.2, 4.5, 1.33)

        integers = IntArray(3) { 5 }
        doubles = DoubleArray(3) { 1.7 }


    }
}