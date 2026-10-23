package kg.iuca.laba_3

// Task 3 (используется также в Task 6 и Task 7) — транспорт
open class Vehicle(val brand: String) {
    init {
        require(brand.isNotBlank()) { "Название бренда не может быть пустым" }
    } // open позволяет переопределять методы

    open fun info(): String = "Транспорт (бренд=$brand)"
    open fun maxSpeedKmh(): Int = 0
}

class Car(brand: String, val doors: Int) : Vehicle(brand) {
    init { require(doors >= 2) { "У автомобиля должно быть минимум 2 двери" } }

    override fun info(): String = "Автомобиль $brand, дверей: $doors"
    override fun maxSpeedKmh(): Int = 200
}

class Bike(brand: String, val gears: Int) : Vehicle(brand) {
    init { require(gears >= 1) { "У велосипеда должна быть минимум 1 передача" } }

    override fun info(): String = "Велосипед $brand, передач: $gears"
    override fun maxSpeedKmh(): Int = 30
}
