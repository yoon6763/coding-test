package baekjoon.silver.s5

fun main() {
    val k = readln().toInt()

    val dpA = Array(k + 1) { 0 }
    val dpB = Array(k + 1) { 0 }
    dpA[0] = 1
    dpB[0] = 0
    dpA[1] = 0
    dpB[1] = 1

    for (i in 1..k) {
        dpA[i] = dpB[i - 1]
        dpB[i] = dpA[i - 1] + dpB[i - 1]
    }

    println("${dpA[k]} ${dpB[k]}")
}