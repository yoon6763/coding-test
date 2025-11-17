package baekjoon.bronze.b3

fun main() {
    var ans = 0.0
    while (true) {
        val input = readln()
        if (input == "EOI") break
        ans += when (input) {
            "Paper" -> 57.99
            "Printer" -> 120.50
            "Planners" -> 31.25
            "Binders" -> 22.50
            "Calendar" -> 10.95
            "Notebooks" -> 11.20
            "Ink" -> 66.95
            else -> 0.0
        }
    }
    println(String.format("$%.2f", ans))
}