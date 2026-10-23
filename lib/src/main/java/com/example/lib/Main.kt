package kg.iuca.laba_3

fun main() {
    println("Task 1 ")
    val s1 = Sensor("S 01", 22.0)
    val s2 = Sensor("S 02", 18.5)
    s1.update(24.8)
    println(s1)
    println(s2)

    println("\nTask 2")
    val counter = Counter()
    counter.inc(2)
    println("Значение счетчика: ${counter.value()}")

    println("\nTask 3, 6")
    val v: Vehicle = Car("Volvo", 4)
    println("Информация через upcast: ${v.info()}") // Вызовется метод Car

    val fleet = listOf(Car("Lada", 4), Bike("Кама", 1))
    printFleet(fleet)

    println("\nTask 7")
    println("Дверей: ${doorsOrZero(Car("Audi", 4))}")
    println("Дверей: ${doorsOrZero(Bike("Giant", 21))}")

    val c = Bike("X", 3) as? Car
    println("Результат безопасного приведения: $c") // Вернет null

    println("\nTask 4")
    val employees = listOf(
        Employee("Анна", 30000),
        Accountant("Борис", 40000, 15),
        Intern("Виктор", 20000, "Анна")
    )
    employees.forEach { println(it.describe()) }
    println("Общий фонд оплаты труда: ${employees.sumOf { it.pay() }} руб.")

    println("\nTask 5")
    val parcels = listOf(
        Parcel("P1", 5.0),
        ExpressParcel("P2", 5.0),
        EconomyParcel("P3", 5.0)
    )
    println("Общая стоимость доставки: %.2f".format(totalShipping(parcels)))

    println("\nTask 8")
    val assessments = listOf(
        Quiz("Тест по Kotlin", 20, 0.1),
        Project("Курсовой проект", 100, 0.2)
    )
    println("${assessments[0].title} результат из 20: ${assessments[0].scoreTowardGrade(20)}")
    println("${assessments[1].title} результат из 110: ${assessments[1].scoreTowardGrade(110)}")

    println("\nTask 9")
    val notifications = listOf(
        EmailNotification("Ваш заказ отправлен", "user@test.com"),
        SmsNotification("Ваш код подтверждения 4455", "+123456789")
    )
    sendAll(notifications)

    println("\nTask 10")
    val tickets = listOf(
        AdultTicket("A1", 100),
        ChildTicket("C1", 100, "G-1"),
        ChildTicket("C2", 100, "G-9"),
        VipTicket("V1", 100, true)
    )
    println("Итого к оплате: ${checkout(tickets)}")
    println("Коды опекунов: ${childGuardianCodes(tickets).joinToString(", ")}")
}
