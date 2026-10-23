package kg.iuca.laba_3

// Task 7
fun doorsOrZero(v: Vehicle): Int { // Если v это Car, компилятор приводит тип, давая доступ к свойству doors
    return if (v is Car) v.doors else 0
}
