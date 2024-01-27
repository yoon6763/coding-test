package baekjoon.bronze.b3


fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val np = readLine().split(" ")
        val n = np[0].toInt()
        val p = np[1].toDouble()

        var ans = 0

        for (j in 0..<n) {
            val (v,f,c) = readLine().split(" ").map { it.toInt() }
            if ((p / v) * c <= f) ans++
        }
        println(ans)
    }
}