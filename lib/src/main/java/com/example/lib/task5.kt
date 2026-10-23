package kg.iuca.laba_3

// Task 5
open class Parcel(val id: String, val weightKg: Double) {
    init { require(weightKg > 0) { "Вес посылки должен быть положительным" } }

    open fun shippingCost(): Double = weightKg * 2.0
}

class ExpressParcel(id: String, weightKg: Double) : Parcel(id, weightKg) {
    override fun shippingCost(): Double = super.shippingCost() + 15.0
}

class EconomyParcel(id: String, weightKg: Double) : Parcel(id, weightKg) {
    override fun shippingCost(): Double = super.shippingCost() * 0.8
}

fun totalShipping(parcels: List<Parcel>): Double = parcels.sumOf { it.shippingCost() }
