package baekjoon.bronze.b1

fun main() {
    repeat(readln().toInt()) {
        val n = readln().toInt()
        val arr = Array(n) { readln() }

        var horizontal = true
        for (i in 0..<n) {
            if (arr[i] != arr[i].reversed()) {
                horizontal = false
                break
            }
        }

        val reversed = arr.reversed()

        var vertical = true
        for (i in 0..<n) {
            if (arr[i] != reversed[i]) {
                vertical = false
                break
            }
        }

        println(
            when {
                vertical && horizontal -> "Magnificent"
                horizontal -> "Graceful"
                vertical -> "Beautiful"
                else -> "Useless"
            }
        )
    }
}