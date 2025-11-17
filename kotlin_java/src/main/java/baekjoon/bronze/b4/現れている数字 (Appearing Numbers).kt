package baekjoon.bronze.b4

fun main() {
    val count = IntArray(10)
    readln()
    readln().split(" ").map { it.toInt() }.forEach { count[it]++ }
    ArrayList<Int>().apply { count.forEachIndexed { index, i -> if (count[index] >= 1) add(index) } }.sorted()
        .joinToString("\n").let(::println)
}