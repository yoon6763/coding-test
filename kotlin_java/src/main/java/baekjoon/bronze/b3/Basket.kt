package baekjoon.bronze.b3

fun main() {
    val x = readln().toInt()
    val success = readln().toInt()
    val fail = readln().toInt()

    var score = 0
    if (success == 1) score += x

    if (fail == 1) {
        repeat(if (success == 1) 1 else x) {
            if (readln().toInt() == 1) score++
        }
    }

    println(score)
}
