package baekjoon.silver.s5.생일

data class Person(val name: String, val day: Int, val month: Int, val year: Int)
fun main() {
    val people = Array(readln().toInt()) {
        val (name, day, month, year) = readln().split(" ")
        Person(name, day.toInt(), month.toInt(), year.toInt())
    }.sortedWith(compareBy({ it.year }, { it.month }, { it.day }))
    println(people.last().name)
    println(people.first().name)
}