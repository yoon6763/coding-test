package baekjoon.bronze.b1

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr1 = Array(n) { readln() }
    val arr2 = Array(n) { readln() }

    repeat(n) { index ->
        val expanded = Array(m * 2) { charIndex -> arr1[index][charIndex / 2] }
        if (expanded.joinToString("") != arr2[index]) {
            println("Not Eyfa")
            return
        }
    }

    println("Eyfa")
}