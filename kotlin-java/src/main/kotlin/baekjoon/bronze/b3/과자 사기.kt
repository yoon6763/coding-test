package baekjoon.bronze.b3

fun main() {
    val arr = List(3) {
        val (price, weight) = readln().split(" ").map { it.toDouble() }
        if (price * 10 >= 5000) (weight * 10) / (price * 10 - 500) else (weight * 10) / (price * 10)
    }
    print("SNU"[arr.indexOf(arr.maxOrNull())])
}