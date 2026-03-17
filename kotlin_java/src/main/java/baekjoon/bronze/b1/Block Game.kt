package baekjoon.bronze.b1

fun main() {
    val result = IntArray(26)

    repeat(readln().toInt()) {
        val (a, b) = readln().split(" ")

        val countA = IntArray(26)
        val countB = IntArray(26)

        for (c in a) countA[c - 'a']++
        for (c in b) countB[c - 'a']++
        for (i in 0 until 26) result[i] += maxOf(countA[i], countB[i])
    }

    println(result.joinToString("\n"))
}