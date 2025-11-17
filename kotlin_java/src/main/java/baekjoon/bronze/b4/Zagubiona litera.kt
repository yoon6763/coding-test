package baekjoon.bronze.b4

fun main() {
    val set = mutableSetOf<Char>()
    set.addAll('A'..'Z')
    readln().forEach { set.remove(it) }
    println(set.first())
}