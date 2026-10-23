package kg.iuca.laba_3

// Task 10
open class Ticket(val code: String, val basePrice: Int) { // Ключевое слово 'open' разрешает наследование от этого класса
    open fun price(): Int = basePrice
}

// Просто наследует Ticket без изменений, логика price() остается базовой. Это взрослый билет
class AdultTicket(code: String, basePrice: Int) : Ticket(code, basePrice)

// Добавляем собственное свойство guardianCode (код опекуна). Это детский билет
class ChildTicket(code: String, basePrice: Int, val guardianCode: String) : Ticket(code, basePrice) {
    // Переопределяем расчет цены: берем базовую цену из родительского класса (super.price()) и делим на 2
    override fun price(): Int = super.price() / 2
}

// VIP-билет. Добавляем флаг loungeAccess (доступ в зону отдыха)
class VipTicket(code: String, basePrice: Int, val loungeAccess: Boolean) : Ticket(code, basePrice) {
    // Переопределяем цену: базовая цена + 50 (если loungeAccess == true) или + 20 (если false)
    override fun price(): Int = super.price() + if (loungeAccess) 50 else 20
}

// Принимаем список базовых Ticket, но при вызове it.price() программа сама определит реальный тип билета
fun checkout(tickets: List<Ticket>): Int = tickets.sumOf { it.price() }

fun childGuardianCodes(tickets: List<Ticket>): List<String> {
    // Создаем пустой изменяемый список для сбора кодов опекунов
    val codes = mutableListOf<String>()
    for (t in tickets) {
        if (t is ChildTicket) { // Проверяем, является ли текущий билет детским
            codes.add(t.guardianCode)
        }
    }
    return codes
}
