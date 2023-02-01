package baekjoon.bronze.b5

fun main() {
    var n = 0.0
    when (readLine()!!) {
        "A+" -> n = 4.3
        "A0" -> n = 4.0
        "A-" -> n = 3.7
        "B+" -> n = 3.3
        "B0" -> n = 3.0
        "B-" -> n = 2.7
        "C+" -> n = 2.3
        "C0" -> n = 2.0
        "C-" -> n = 1.7
        "D+" -> n = 1.3
        "D0" -> n = 1.0
        "D-" -> n = 0.7
        "F" -> n = 0.0
    }
    println(n)
}