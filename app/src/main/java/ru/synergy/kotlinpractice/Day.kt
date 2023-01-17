package ru.synergy.kotlinpractice




// ENAM CLASSES

/* enum class Day {
    MONDAY{
        val startHour = 6
        fun printName() {
            print("Доброе утро, понедельник")
        }
          }, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
*/

enum class Operation {
    ADD, SUBTRACT, MULTIPLY
}

fun operate(n1: Int, n2:Int, op: Operation): Int {
    when (op) {
        Operation.ADD -> return n1 + n2
        Operation.SUBTRACT -> return n1 - n2
        Operation.MULTIPLY -> return n1 * n2
    }
}

interface Base {
    fun someFun()
}

class BaseImp(): Base {
    override fun someFun() {
        TODO("Not yet implemented")
    }
}

class Derived(someBase: Base) : Base by someBase

interface Messanger{
    fun send(messanger: String)
}

class InstantMessager(val programName: String) : Messanger {
    override fun send(message: String) {
        print("Messanger '$message' has been sent")
    }
}

class SmartPhone(val name: String, m: Messanger) : Messanger by m

fun test() {
    val telegram = InstantMessager("Telegram")
    val whatsapp = InstantMessager("WhatsApp")

    val pixel = SmartPhone("Pixel 5", telegram)
    pixel.send("Hello from Kotlin")
    pixel.send("Hello from synergy")

}