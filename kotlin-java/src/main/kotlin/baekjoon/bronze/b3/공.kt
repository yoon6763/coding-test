package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val cup = BooleanArray(3)
    cup[0] = true

    repeat(readLine().toInt()) {
        val (a, b) = readLine().split(" ").map { it.toInt() - 1 }
        val temp = cup[a]
        cup[a] = cup[b]
        cup[b] = temp
    }

    println(cup.indexOf(true) + 1)
}