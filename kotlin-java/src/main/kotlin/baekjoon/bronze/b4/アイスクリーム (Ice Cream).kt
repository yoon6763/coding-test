package baekjoon.bronze.b4

fun main() {
    val price = 250
    val (s, a, b) = Array(3) { readln().toDouble() }

    if (s <= a) {
        println(price)
        return
    }
    val add = 100 * Math.ceil((s - a) / b)
    println(price + add.toInt())
}