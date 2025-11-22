package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()

    val left = List(n) { readln() }
    val right = List(m) { readln() }

    left.forEach { l ->
        right.forEach { r ->
            println("$l as $r")
        }
    }
}
