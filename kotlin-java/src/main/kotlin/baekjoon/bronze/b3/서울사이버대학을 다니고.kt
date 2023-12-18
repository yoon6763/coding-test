package baekjoon.bronze.b3

fun main() {
    readln()
    val count = IntArray(26)
    readln().forEach { if (it - 'a' in 0..<26) count[it - 'a']++ }
    println(count.maxOrNull())
}