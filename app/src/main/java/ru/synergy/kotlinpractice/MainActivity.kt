package ru.synergy.kotlinpractice


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import email.*
import sms.Message as SmsMessage
import sms.send as sendSms



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* ПАКЕТЫ И ИМПОРТЫ

        val tom: Person = Person ("Tom", 10)
        val alice: Person = Person ("Alice", 45)
        val bob: Person = Person ("Bob", 23)
        tom.age = 37
        tom.sayHello()
        tom.go("The shop")
        print(tom.personToString())

        val mvMessage = Message("Hello Kotlin")
        send(mvMessage, address = "Test@gmail.com")

        val mvSms = SmsMessage("Marina is smart")
        sendSms(mvSms, address = "+79108966942")

         */

        /* НАСЛЕДОВАНИЕ

        var ted: Employee = Employee("Ted", "Microsoft")
        ted.age = 20 // 20
        ted.age = -100 // 20
        */

        // АБСТРАКТНЫЕ КЛАССЫ и МЕТОДЫ

        // val kate: Human = Human("Marina") - так нельзя, потому то Human абстрактный класс

        // DATA CLASSES

        val katy: People = People("Katy", 37)
        var (userName, userAge) = katy


    }
}