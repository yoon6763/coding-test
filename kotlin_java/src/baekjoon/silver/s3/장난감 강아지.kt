package baekjoon.silver.s3

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val cmd = readLine()
    var (x, y) = 0L to 0L
    cmd.forEach {
        when (it) {
            'U' -> x++
            'D' -> x--
            'R' -> y++
            'L' -> y--
        }

        if (x == 0L && y == 0L) {
            println("YES")
            return@with
        }
    }

    val xDiff = x
    val yDiff = y
    x = 0L
    y = 0L

    cmd.forEach { c ->
        when (c) {
            'U' -> x++
            'D' -> x--
            'R' -> y++
            'L' -> y--
        }

        for (j in 1..<k) {
            val nx = x + xDiff * j
            val ny = y + yDiff * j

            if (nx == 0L && ny == 0L) {
                println("YES")
                return@with
            }

            if (xDiff > 0 && nx > 0 || xDiff < 0 && nx < 0 || yDiff > 0 && ny > 0 || yDiff < 0 && ny < 0) break
        }
    }
    println("NO")
}