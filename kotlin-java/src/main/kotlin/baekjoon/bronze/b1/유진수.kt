package baekjoon.bronze.b1

fun main() {
    val n = readln()

    for (i in 1 until n.length) {
        val a = n.substring(0, i)
        val b = n.substring(i)
        var sumA = 1L
        var sumB = 1L

        for (j in a.indices) {
            sumA *= a[j].digitToInt()
        }

        for (j in b.indices) {
            sumB *= b[j].digitToInt()
        }

        if (sumA == sumB) {
            println("YES")
            return
        }
    }

    println("NO")
}