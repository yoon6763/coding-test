package baekjoon.bronze.b3

fun main() {
    repeat(readln().toInt()) {
        val n = readln().toInt()
        val heights = readln().split(" ").map { it.toInt() }

        var ans = 0
        for (i in 1..<n - 1) {
            if (heights[i - 1] < heights[i] && heights[i] > heights[i + 1]) ans++
        }
        println("Case #${it + 1}: $ans")
    }
}
