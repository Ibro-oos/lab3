package kg.iuca.laba_3

// Task 4
open class Employee(val name: String, val baseSalary: Int) {
    init {
        require(name.isNotBlank()) { "Имя сотрудника не может быть пустым" }
        require(baseSalary >= 0) { "Базовая зарплата не может быть отрицательной" }
    }

    open fun pay(): Int = baseSalary
    open fun describe(): String = "$name: ${pay()} руб."
}

class Accountant(name: String, baseSalary: Int, val bonusPercent: Int) : Employee(name, baseSalary) {
    init { require(bonusPercent in 0..100) { "Процент бонуса должен быть от 0 до 100" } }

    override fun pay(): Int = super.pay() + (super.pay() * bonusPercent / 100)
    override fun describe(): String = "Бухгалтер ${super.describe()}"
}

class Intern(name: String, baseSalary: Int, val mentor: String) : Employee(name, baseSalary) {
    init { require(mentor.isNotBlank()) { "Имя наставника обязательно" } }

    override fun pay(): Int = super.pay() / 2 // Делим базовую зарплату на 2 через super.pay(), не дублируя логику
    override fun describe(): String = "Стажер ${super.describe()} (Наставник: $mentor)"
}
