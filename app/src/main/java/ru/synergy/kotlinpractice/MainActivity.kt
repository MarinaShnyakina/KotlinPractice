package ru.synergy.kotlinpractice


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import ru.synergy.kotlinpractice.databinding.ActivityYoutuberBinding
import java.util.Objects


class MainActivity : AppCompatActivity() {

    /* ПЕРЕДАЧА ДАННЫХ МЕЖДУ ОДНОЙ КОРУТИНЫ И ДРУГОЙ

    fun CoroutineScope.getUsers(): ReceiveChannel<String> = produce {
        val users = listOf("Tom", "Marina", "Katy")
        for (user in users) {
            send(user)
        }
    }

    */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtuber)

        // ВНУТРЕННИЕ И АНОНИМНЫЕ КЛАССЫ

        /*
        val userAcc:Person = Person("qwerty", "123456")
        userAcc.showDetails()

        val acc = BankAccount(10_000)
        acc.Transaction(2400).pay()

        */

        // АНОНИМНЫЕ ОБЪЕКТЫ

        /*
       val tom = object {
            val name = "Tom"
            var age = 37
            fun sayHello() {
                print("Hi, my name is $name")
            }
        }

        print("Name: ${tom.name} Age: ${tom.age}")
        tom.sayHello()
    }
    */

        // НАСЛЕДОВАНИЕ АНОНИМНЫХ ОБЪЕКТОВ

        /*
    val tom = object: Person("Tom", "123456") {
        var age = 37
        val company = "JetBrains"
        fun sayHello() {
            print("Hi, my name is $userName")
        }
    }

    print("Name: ${tom.userName} Age: ${tom.age}")
    tom.sayHello()
}
*/

        // ВЫЗОВ ФУНКЦИИ

        /*
        hello(
            object: Person("Katy", "654321") {
                var company = "JetBrains"
                override fun sayHello() {
                    print("Hi, mu name is $userName. I work in $company")
                }
            }
        )
        */

        /*
        val tom = createPerson("Tom", "JetBrains")
        tom.sayHello()

        */

        // ОПЕРАТОР ?

        /*
        var n: Int? = null
        var company: String? = "Google"
        var nameCopy: String = company ?: "Undefined"
        /* такого рода конструкция говорит нам следующее:
        если company не null, то давай нам то, что записано в company
        если там null, то в таком случае верни значение Undefined и положи в nameCopy
         */
        if (company != null) {
            nameCopy = company
        }
        // if - это выражение то же самое, что var nameCopy: String = company ?: "Undefined"

        print(company?.length ?: 0) // тут - если объект не null то вызови lenght, если null, то мы не сделаем ничего :-)
        val i: Int? = company?.length
        */

        /*
        var tom: Person? = Person("Tom", "432345")
        val tomName: String? = tom?.userName?.uppercase() ?: "Undefined"
        print(tomName) // TOM

        var bob: Person? = null
        val bobName: String? = bob?.userName?.uppercase() ?: "Undefined"
        print(bobName) // null
        */

        // ОПЕРАТОР !!

        /*
        try {
            val name: String? = "Tom"
            val id: String = name!!
            /*
            val name: String? = null
            val id: Int = name!!.length
             */
            print(id)
        } catch (e: java.lang.Exception) {
            print(e.message)
        }
        */

        /* ПРЕОБРАЗОВАНИЕ ТИПОВ

        val s: String = "12"

        обработка исключений
        try {
            val d: Int = s.toInt()
            print(d)
        } catch (e:Exception) {
            print(e.message)
        }
        */

        /* SMART CAST OPERATION
         значение is тип_данных

        val tom = Person("Tom", "546567")

        if(tom is Person) print("Tom is person")
        else print("Tom is not person")
        */

        /*
        ИСПОЛЬЗОВАНИЕ SMART CAST - is

        val tom = Person("Tom")
        if (tom.phone is SmartPhone) {
            print("SmartPhone : ${tom.phone.name}, OS: ${tom.phone.os}")
        } else print("Phone: ${tom.phone.name}")

        */

        /*
        SMART CAST AS - явное преобразование
        значение as тип_данных

        val hello: String? = "Hello Kotlin"
        val message: String = hello as String
        print(message)

        val hello: String? = null
        val message: String? = hello as? String // ClassCastException
        print(message)
        */

        /* ФУНКЦИЯ РАСШИРЕНИЯ

        fun тип.имя_функции(параметры): возвращаемый_тип {
        тело функции
        }

        var hello: String = "Hello World"
        print(hello.wordCount('l')) // 3
        print(hello.wordCount('o')) // 2
        print(4.square())
        print(6.square())

        */

        /*
            KOTLIN COLLECTION

            var numbers = listOf(1,2,3,4,5,6,7, null)
            var numbers2: List<Int> = listOf(1,2,3,4)
            numbers.get(1)
            numbers.elementAtOrNull(1)
            numbers.first()
            numbers.last()

            */

        /*
         MUTABLE COLLECTION

        var numbers: ArrayList<Int> = arrayListOf(1,2,3,4,5,6)
        var numbers2: MutableList<Int> = mutableListOf(1,2,3,4,5,6)

        numbers.add(4)
        numbers.addAll(mutableListOf(2,3,5,6))

        */

        /*
        IMMUTABLE SET

        var number: Set<Int> = setOf(5,6,8)
        number.minus(6) // 5,8
        number.plus(9) // 5,6,8,9

        */

        /*
        MUTABLE SET

        var numbers1: MutableSet<Int> = mutableSetOf(35,36,37)
        val numbers2: HashSet<Int> = hashSetOf(5,6,7)
        val numbers3: LinkedHashSet<Int> = linkedSetOf(23, 12, 57)
        */

        /* MAP

        val countries: Map<String, Int> = mapOf("USA" to 300, "France" to 60, "Russia" to 30)
        print(countries["USA"]) // 300

        for(country in countries) {
            print("${country.key} - ${country.value}")
        }
        */

        // КОРУТИНЫ

        /*
        lifecycleScope.launch {

            doWork()

            print(Thread.currentThread().name)
            val deferred = async(Dispatchers.Default) {
                10 + 10
            }
            print(deferred.await())
        }

        lifecycleScope.launch {
            doWork()

            print("I am finished")
        }
    }

    suspend fun doWork() {
        for (i in 0..5) {
            delay(400L)
            print(i)
        }
        print("Hello coroutines")
    }
    */


        /* КОРУТИННЫЕ ПОТОКИ

        var job: Job = lifecycleScope.launch (start = CoroutineStart.LAZY) {
        launch {
            doWork()
        }

        try {
            doWork()
        } catch (e: CancellationException) {
            print("Мы были прерваны")
        } finally {
        }
        print(Thread.currentThread().name)
        val deferred: Deferred<Int> = async(Dispatchers.Default, start = CoroutineStart.LAZY) {
            10 + 10
        }
        print(deferred.await())
    }

        job.start()
        print("I am finished")
    }
}

suspend fun doWork() {
    for (i in 0..5) {
        delay(400L)
        print(i)
    }
    print("Hello coroutines")
}

*/

        /* ПЕРЕДАЧА ДАННЫХ ВНУТРИ КОРУТИНЫ

        var channel = Channel<Int>()

        lifecycleScope.launch {

            for(n in 1..5) {
                channel.send(n)
            }

            repeat(5) {
                val number = channel.receive()
                print(number)
            }

            channel.close()

        }

        */

        /* ПЕРЕДАЧА ДАННЫХ МЕЖДУ ОДНОЙ КОРУТИНЫ И ДРУГОЙ

        val users = getUsers()
        users.consumeEach { users -> print(users) }
        */


        /*
    fun hello(person: Person) {
        person.sayHello()
    }
    */

        /*
    private fun createPerson (_name: String, _company: String) = object {
        val name = _name
        var company = _company
        fun sayHello() = print("Hi, my name is $name. I work in $company")
    }
    */

        /*
    ИСПОЛЬЗОВАНИЕМ SMART CAST

    open class Phone(val name: String)
    class SmartPhone(name: String, var os: String): Phone(name)

    open class Person(val name: String) {
        val phone: Phone = SmartPhone ("Pixel", "Android")
    }
    */

        /* ФУНКЦИЯ РАСШИРЕНИЯ
    private fun String.wordCount(c: Char): Int {
        var count = 0
        for (n in this) {
            if(n == c) count++
        }
        return count
    }

    private fun Int.square():Int {
        return this * this
    }

    */

        // АСИНХРОННЫЕ ПОТОКИ
/*
        val userFlow = flowOf("Katy", "Marina", "Hvost", "Hrysha")

        // userFlow.collect()  -  тут нужна коротина

        lifecycleScope.launch {
            getUsers().collect { user ->
                Toast.makeText(applicationContext, user, Toast.LENGTH_SHORT).show()
            }
        }

    }

        fun getUsers(): Flow<String> = flow {
            val database = listOf("Katy", "Marina", "Hvost", "Hrysha")   // условная база данных
            var i = 1
            for (item in database) {
                delay(400L)   // имитация продолжительной работы
                print("Emit $i item")
                emit(item)   // имитируем значение
                i++
            } */
        }

}