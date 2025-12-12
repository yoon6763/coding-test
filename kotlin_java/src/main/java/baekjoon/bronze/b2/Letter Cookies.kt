package baekjoon.bronze.b2

fun main() {
    repeat(readln().toInt()) {
        val have = IntArray(26)
        readln().forEach {
            have[it - 'A']++
        }

        repeat(readln().toInt()) {
            val need = IntArray(26)
            readln().forEach {
                need[it - 'A']++
            }

            println(if ((0 until 26).all { need[it] <= have[it] }) "YES" else "NO")
        }
    }
}
