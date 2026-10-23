package kg.iuca.laba_3

// Task 1
class Sensor(val id: String, var reading: Double) {
    init { // Проверяем, что ID не пустой
        require(id.isNotBlank()) { "ID сенсора не должен быть пустым" } // Проверяем стартовое значение на валидность
        require(reading.isFinite()) { "Начальное значение должно быть конечным числом" }
    }

    fun update(reading: Double) { // Исключаем NaN и бесконечности
        require(reading.isFinite()) { "Обновленное значение должно быть конечным (получено $reading)" }
        this.reading = reading
    }

    override fun toString(): String {
        return "Сенсор(id=$id, значение=$reading)"
    }
}
