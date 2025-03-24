package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(n) { readLine().toInt() }.sortedDescending()
    val levelCut = intArrayOf(60, 100, 140, 200, 250)
    var levelSum = 0
    var ability = 0

    for (i in 0..<minOf(n, 42)) {
        levelSum += arr[i]
        for (lv in levelCut) {
            if (arr[i] >= lv) ability++
        }
    }

    println("$levelSum $ability")
}