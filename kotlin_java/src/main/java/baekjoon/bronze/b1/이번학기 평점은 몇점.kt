package baekjoon.bronze.b1

import java.text.DecimalFormat

fun main() {
    var grade = 0.0
    var num = 0.0

    repeat(readln().toInt()) {
        val (title, n, g) = readln().split(" ")
        grade += when(g) {
            "A+" -> 4.3
            "A0" -> 4.0
            "A-" -> 3.7
            "B+" -> 3.3
            "B0" -> 3.0
            "B-" -> 2.7
            "C+" -> 2.3
            "C0" -> 2.0
            "C-" -> 1.7
            "D+" -> 1.3
            "D0" -> 1.0
            "D-" -> 0.7
            else -> 0.0
        } * n.toInt()
        num += n.toInt()
    }
    println(DecimalFormat("#0.00").format((Math.round(grade / num * 100).toDouble() / 100)))
}