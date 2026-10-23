package kg.iuca.laba_3

import kotlin.math.roundToInt

// Task 8
open class Assessment(val title: String, val maxPoints: Int) {
    open fun scoreTowardGrade(raw: Int): Double { // Дефолтная формула: ограничиваем сырой балл максимумом и переводим в дробь от 0 до 1
        return (raw.coerceIn(0, maxPoints)).toDouble() / maxPoints
    }
}

class Quiz(title: String, maxPoints: Int, val penaltyIfLate: Double) : Assessment(title, maxPoints) {
    init { require(penaltyIfLate in 0.0..0.5) { "Штраф должен быть от 0.0 до 0.5" } }

    override fun scoreTowardGrade(raw: Int): Double {
        return super.scoreTowardGrade(raw) * (1.0 - penaltyIfLate) // Применяем штраф к коэффициенту, вычисленному родительским классом
    }
}

class Project(title: String, maxPoints: Int, val bonusCap: Double) : Assessment(title, maxPoints) {
    init { require(bonusCap >= 0.0) { "Бонусный лимит не может быть отрицательным" } }

    override fun scoreTowardGrade(raw: Int): Double {
        val baseRatio = super.scoreTowardGrade(raw)
        val extraPoints = (raw - maxPoints).coerceIn(0, (maxPoints * bonusCap).roundToInt()) // Считаем бонусные баллы, если набрано больше максимума
        val bonusRatio = extraPoints.toDouble() / maxPoints
        return baseRatio + bonusRatio
    }
}
