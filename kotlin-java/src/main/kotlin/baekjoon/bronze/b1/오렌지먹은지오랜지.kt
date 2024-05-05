package baekjoon.bronze.b1

fun main() {
    val n = readln().toInt()
    val str = readln()

    for (i in 0..<n) {
        val left = str.substring(0, i)
        val right = str.substring(n - i, n)

        var diff = 0
        for (j in 0 until i) {
            if (left[j] != right[j]) {
                diff++
                if (diff > 1) break
            }
        }

        if (diff == 1) {
            println("YES")
            return
        }
    }

    println("NO")
}