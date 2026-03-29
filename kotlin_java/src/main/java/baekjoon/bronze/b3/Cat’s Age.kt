package baekjoon.bronze.b3

fun main() {
    val (y, m) = readln().split(" ").map { it.toInt() }
    var totalMonths = 0

    when (y) {
        0 -> totalMonths = m * 15
        1 -> totalMonths = 15 * 12 + m * 9
        else -> {
            totalMonths = 15 * 12
            totalMonths += 9 * 12
            totalMonths += (y - 2) * 4 * 12
            totalMonths += m * 4
        }
    }

    println("${totalMonths / 12} ${totalMonths % 12}")
}