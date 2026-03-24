package baekjoon.bronze.b2

fun main() {
    while (true) {
        val line = readLine() ?: break
        val parts = line.split(" ").map { it.toInt() }

        var m = parts[0]
        var p = parts[1]
        var l = parts[2]
        val e = parts[3]
        val r = parts[4]
        val s = parts[5]
        val n = parts[6]

        repeat(n) {
            val sum = m
            m = p / s
            p = l / r
            l = sum * e
        }

        println(m)
    }
}