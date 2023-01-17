package ru.synergy.kotlinpractice

class Car: Movable {
    override var speed: Int = 60

    override fun move() {
        print("Машина едет со скоростью 60 км/ч")
    }
}

class Aircraft: Movable {
    override var speed: Int = 800

    override fun move() {
        print("Самолет летит со скоростью 800 км/ч")
    }
    override fun stop() {
        print("Приземление")
    }
}
