package baekjoon.bronze.b4

fun main() {
    while (true) {
        val s = readln()
        if (s == "0") break

        val num = s.toInt()
        val arr = readln().split(" ").map { it.toInt() }.toIntArray()
        var max = 0

        for (i in 0..<num - 2) {
            max = maxOf(max, arr[i] + arr[i + 1] + arr[i + 2])
        }

        println(max)
    }
}
