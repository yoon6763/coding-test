package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val count = IntArray(5)

    repeat(n) {
        val s = readln()
        for (i in 0 until 5) {
            if (s[i] == 'Y') count[i]++
        }
    }

    val max = count.maxOrNull()!!
    val result = mutableListOf<Int>()

    for (i in 0 until 5) {
        if (count[i] == max) result.add(i + 1)
    }

    println(result.joinToString(","))
}