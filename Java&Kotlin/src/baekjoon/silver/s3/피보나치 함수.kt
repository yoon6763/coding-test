package baekjoon.silver.s3

val fiboCount = Array(41) { Array(2) { -1 } } // 0, 1 카운트

fun main() {
    fiboCount[0][0] = 1
    fiboCount[0][1] = 0
    fiboCount[1][0] = 0
    fiboCount[1][1] = 1

    repeat(readLine()!!.toInt()) {
        when (val n = readLine()!!.toInt()) {
            0 -> println("1 0")
            1 -> println("0 1")
            else -> {
                val result = fibonacci(n)
                println("${result[0]} ${result[1]}")
            }
        }
    }
}

fun fibonacci(n: Int): Array<Int> {
    if (fiboCount[n][0] == -1 || fiboCount[n][1] == -1) {
        fiboCount[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0]
        fiboCount[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1]
    }
    return fiboCount[n]
}