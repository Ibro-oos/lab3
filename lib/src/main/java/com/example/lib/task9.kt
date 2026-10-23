package kg.iuca.laba_3

// Task 9
open class Notification(private val payload: String) {
    protected fun body(): String = payload // protected позволяет наследникам видеть метод, но скрывает его от внешнего кода
    open fun render(): String = body()
}

class EmailNotification(payload: String, val to: String) : Notification(payload) {
    override fun render(): String = "[Email для $to]: ${body()}"
}

class SmsNotification(payload: String, val phone: String) : Notification(payload) {
    override fun render(): String = "[SMS на номер $phone]: ${body()}"
}

fun sendAll(items: List<Notification>) {
    items.forEach { println(it.render()) }
}
