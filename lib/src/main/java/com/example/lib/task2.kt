package kg.iuca.laba_3

// Task 2
class Counter(start: Int = 0) { // Инкапсуляция: состояние спрятано от внешнего мира
    private var count: Int = start
    fun value(): Int = count

    fun inc(step: Int = 1) {
        require(step > 0) { "Шаг должен быть строго больше нуля (> 0)" }
        count += step
    }

    fun reset() {
        count = 0
    }
}
