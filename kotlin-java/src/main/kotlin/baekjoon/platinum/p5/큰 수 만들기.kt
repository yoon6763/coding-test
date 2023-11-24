package baekjoon.platinum.p5

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ")

    if (arr.all { it == "0" }) {
        println(0)
        return
    }

    arr.sortedWith { o1, o2 ->
        if (o1 + o2 < o2 + o1) 1 else -1
    }.joinToString("").let(::println)
}