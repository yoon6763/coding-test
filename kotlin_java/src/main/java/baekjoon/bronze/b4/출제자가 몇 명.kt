package baekjoon.bronze.b4

fun main() {
    println(List(readln().toInt()) {
        readln().split(" ").map { it.toInt() }
    }.count { (a, b, c, d) ->
        a >= 1000 || b >= 1600 || c >= 1500 || d in 0..30
    })
}
