package baekjoon.bronze.b4

fun main() {
    for (n in 10..99) {
        val s = n.toString()
        if ('8' in s) continue
        val reversed = s.reversed().toInt()
        if (reversed % 4 != 0) continue
        val digitSum = s.sumOf { it - '0' }
        if (digitSum % 6 != 0) continue
        println(n)
        return
    }
}