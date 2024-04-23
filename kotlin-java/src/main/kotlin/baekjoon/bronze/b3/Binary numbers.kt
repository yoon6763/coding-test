package baekjoon.bronze.b3

fun main() {
    val ans = mutableListOf<Int>()
    readln().toInt().toString(2).reversed().forEachIndexed { index, c -> if (c == '1') ans.add(index) }
    println(ans.joinToString(" "))
}