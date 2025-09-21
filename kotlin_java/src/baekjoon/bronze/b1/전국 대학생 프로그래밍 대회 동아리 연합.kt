package baekjoon.bronze.b1

fun main() {
    val (n, b, h, w) = readln().split(" ").map { it.toInt() }

    var minCost = Int.MAX_VALUE

    repeat(h) {
        val p = readln().toInt()

        readln().split(" ").map { it.toInt() }.forEach {
            if (it < n) return@forEach
            val totalCost = n * p
            if (totalCost > b) return@forEach
            minCost = minOf(minCost, totalCost)
        }
    }

    println(if (minCost == Int.MAX_VALUE) "stay home" else minCost)
}
