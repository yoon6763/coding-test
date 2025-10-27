package baekjoon.bronze.b3

fun main() {
    val (year, month, day) = readln().split("-").map { it.toInt() }

    val signs = listOf(
        Triple(1, 20, "Aquarius"),
        Triple(2, 19, "Pisces"),
        Triple(3, 21, "Aries"),
        Triple(4, 20, "Taurus"),
        Triple(5, 21, "Gemini"),
        Triple(6, 21, "Cancer"),
        Triple(7, 23, "Leo"),
        Triple(8, 23, "Virgo"),
        Triple(9, 23, "Libra"),
        Triple(10, 23, "Scorpio"),
        Triple(11, 23, "Sagittarius"),
        Triple(12, 22, "Capricorn")
    )

    var sign = "Capricorn"
    for (i in 0 until signs.size) {
        val (m, d, s) = signs[i]
        if (month > m || (month == m && day >= d)) sign = s else break
    }
    println(sign)
}
