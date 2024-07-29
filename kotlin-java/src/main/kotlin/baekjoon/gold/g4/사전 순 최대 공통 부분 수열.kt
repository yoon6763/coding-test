package baekjoon.gold.g4

fun main() = with(System.`in`.bufferedReader()) {
    readLine()
    val a = readLine().split(" ").map { it.toInt() }.toMutableList()
    readLine()
    val b = readLine().split(" ").map { it.toInt() }.toMutableList()

    val ans = mutableListOf<Int>()

    while (true) {
        if (a.isEmpty() || b.isEmpty()) break

        val (indexA, maxA) = a.withIndex().maxBy { it.value }
        val (indexB, maxB) = b.withIndex().maxBy { it.value }

        if (maxA == maxB) {
            ans.add(maxA)
            a.subList(0, indexA + 1).clear()
            b.subList(0, indexB + 1).clear()
        } else if (maxA > maxB) {
            a.removeAt(indexA)
        } else {
            b.removeAt(indexB)
        }
    }

    println(ans.size)
    println(ans.joinToString(" "))
}