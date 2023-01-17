package ru.synergy.kotlinpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ПРОЦЕДУРНОЕ ПРОГРАММИРОВАНИЕ. МЕТОДЫ. ФУНКЦИИ.

        displayUser("Marina", 33)
        displayUser("Alex", 3)
        displayUser("Kate", 15)
        displayUser("Tony")

        displayUser(age = 20, name = "Maksim") // так можно, но так лучше не писать

        printStrings("Tom", "Oleg", "Sam")
        printStrings("Kotlin", "Java", "C#", "SQL")

        sum(1, 2, 3, 4, 5, 6, 7, 3, 2, 1, 5)

        val nums = intArrayOf(1, 2, 3, 4, 5)
        changeNumbers(
            2,
            *nums
        ) // * - мы ЗАСПРЕДИЛИ (распространили/разбили) то, что передали как массив

        val a = sum(1, 3, 10)

/*        // типы функций
        var message: () -> Unit
        message = ::hello
        message () // Hello Kotlin

        message = ::bye
        message () // Goodbye Kotlin */

        displayMessage(::hello) // Hello Kotlin
        displayMessage(::bye) // Goodbye Kotlin

        // displayMessage(::hello)() // Hello Kotlin Hello Kotlin

        val operation: (Int, Int) -> Int = ::sum
        val result = operation(3, 5)
        print(result) // 8

        // анонимные функции - может выступать в роли аргумента функции, особенно если она используется всего один раз

        val c = fun(x: Int, y: Int): Int = x + y

        // лямбда выражения - сокращенная запись функции

        var sum = {x:Int, y:Int ->
            val result = x+y
            print("$x + $y = $result")
        }

        sum = {x:Int, y:Int -> x+y}

        doOperation(9, 5, fun(x: Int, y: Int): Int = x + y)
        doOperation(9, 5) { x: Int, y:Int ->  x - y } // - с лямбда выражением

        val hello = {print("Hello")}
        hello() // Hello

        val printer = {message: String -> print(message)}
        printer("Hello")

    }

        fun doOperation(x: Int, y:Int, op: (Int, Int) -> Int) {
            val result = op(x,y)
            print(result)
        }



    fun displayUser(name: String, age: Int = 18) {
        print("Name: $name, Age: $age")
    }

    fun double(n: Int) {
       var a = n
    }

    // VARARG operator
    fun printStrings (vararg args: String) { // исп vararg, если надо передавать более, чем один аргумент. Кол-во аргументов может быть бесконечным
        for (str in args) {
            print(str)
        }
    }

    /*fun sum(vararg numbers : Int) {
        // fun sum(operand: String, vararg numbers : Int)   vararg - нельзя передавать первым, он всегда должен быть в конце
        var result = 0
        for (n in numbers)
            result += n
        print(result)
    }*/

    // SPREAD operator "*"
    fun changeNumbers(koef: Int, vararg numbers: Int,) {
        for(number in numbers)
            print(number*koef)
    }

    // ВОЗВРАЩЕНИЕ РЕЗУЛЬТАТА

    fun sum(vararg numbers : Int) {
        var result = 0
        for (n in numbers)
            result += n
        print(result)
    }

    fun sum(x: Int, y: Int): Int { // тут стоит Int, и возвращает соответственно Int (Int, Int) -> Int
        return x+y
    }

    // если функция не возвращает результат, то по умолчанию стоит скрытый тип Unit - он аналогичен void
    fun sum(x: Int, y: Int, z: Int) { // тут стоит скрытый Unit // тут стоит Int, а возвращает Unit (Int, Int, Int) -> Unit
        print(x+y+z)
        // тут по умолчанию стоит return
    }


    // ОДНОСТРОЧНЫЕ ФУНКЦИИ (single expression function)
    fun square(x: Int): Int = x * x // тут можно не писать return, фигурные скобки, тут и так все понятно

    // ЛОКАЛЬНЫЕ ФУНКЦИИ (используются редко, лучше вообще почти не пользоваться, так как смысла почти в этом нет)
    fun compareAge(age1: Int, age2: Int) {
        fun ageIsValid(age: Int): Boolean {
            return (age > 0) and (age < 111)
        }

        if (!ageIsValid(age1) or !ageIsValid(age2)) {
        }
    }

    // ТИПЫ ФУНКЦИЙ
    // определение функции: (типы параметров) -> возвращаемый_тип

    fun hello() { // () -> Unit
        print("Hello Kotlin")
    }

    fun bye() {
        print("Goodbye Kotlin")
     }

    // ФУНКЦИИ ВЫСОКОГО ПОРЯДКА (high order function)

    fun displayMessage(message: () -> Unit) {
        message()

       val c = {_:Any, _:Any ->0} // тут параметры мы не принимаем и воспользоваться ими не можем, если это нужно
       return
    }

   /* fun displayMessage(message: () -> Unit): () -> Unit { // high order function
        message()
        return
    }*/

    // АНОНИМНЫЕ ФУНКЦИИ (не имеют имени - не можем объявить внутри класса)
    /*fun(x: Int, y: Int): Int {
        return x+y
    }*/

}


