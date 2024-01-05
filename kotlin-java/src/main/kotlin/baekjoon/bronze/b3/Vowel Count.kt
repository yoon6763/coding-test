package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    val s = readln()
    var cnt = 0
    s.forEach { if (it in "aeiou") cnt++ }
    println("$s\n${if (cnt > s.length - cnt) 1 else 0}")
}