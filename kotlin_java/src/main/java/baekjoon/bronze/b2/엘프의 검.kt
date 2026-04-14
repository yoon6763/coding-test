package baekjoon.bronze.b2

fun main() {
    while (true) {
        val line = readlnOrNull() ?: break
        val n = line.toLong()

        val visited = BooleanArray(10)
        var count = 0
        var k = 0

        while (count < 10) {
            k++
            var x = n * k

            while (x > 0) {
                val d = (x % 10).toInt()
                if (!visited[d]) {
                    visited[d] = true
                    count++
                }
                x /= 10
            }
        }

        println(k)
    }
}