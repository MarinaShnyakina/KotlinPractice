package ru.synergy.kotlinpractice

// НАСЛЕДОВАНИЕ и ПОЛИМОРФИЗМ

class Employee: Person {
    var company: String = "Undefined"

    constructor(empName: String, _company: String) : super(empName) {
        company = _company
    }

    /* можно написать еще короче
    class Employee (empName: String, private var company: String): Person(empNane)
     */

    private var age: Int = 10
    set(value: Int) {
        if((value > 0) and (value < 110))
            field = value // field == age
    }

    // get(): String = "$age, $company" - должны быть одинаковые значения на выходе

    // ENAM CLASSES
    val day: Day = Day.FRIDAY
    //

    val fullInformation: String
    get() = "$name, $age, $company"


    fun printCompany() {
        print(company)


    }

}