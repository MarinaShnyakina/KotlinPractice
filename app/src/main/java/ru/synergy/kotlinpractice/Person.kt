package ru.synergy.kotlinpractice

import android.location.Location

    /* ПАКЕТЫ И ИМПОРТЫ
class Person (val name: String, var age: Int) {

    fun sayHello() {
        print("Hello my name is $name")
    }

    fun go(location: String) {
        print("$name goes to $location")
    }

    fun personToString(): String {
        return "Name: $name, age: $age"
    }
    }
 */

    // НАСЛЕДОВАНИЕ и ПОЛИМОРФИЗМ

open class Person (val name: String) {
    fun printName() {
        print(name)
    }
}


