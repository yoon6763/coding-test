package baekjoon.bronze.b3

fun main() {
    val (n, r) = readln().split(" ").map { it.toInt() }
    println(((1..n).toSet() - readln().split(" ").map { it.toInt() }.toSet()).let { if(it.isEmpty()) "*" else it.joinToString(" ")  } )
}
