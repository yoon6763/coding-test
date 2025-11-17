package baekjoon.bronze.b3

fun main() {
    while (true) {
        val n = readln().toInt()
        if (n == -1) break
        val speeds = IntArray(n)
        val drives = IntArray(n)
        var ans = 0

        for (i in 0..<n) {
            val (speed, time) = readln().split(" ").map { it.toInt() }
            speeds[i] = speed
            drives[i] = time
        }

        for (i in 0..<n) ans += if (i == 0) drives[i] * speeds[i] else speeds[i] * (drives[i] - drives[i - 1])
        println("$ans miles")
    }
}