package baekjoon.bronze.b4

fun main() {
    val (n, p) = List(2) { readln().toInt() }
    var maxDiscount = 0

    if (n >= 5) maxDiscount = maxOf(maxDiscount, 500)
    if (n >= 10) maxDiscount = maxOf(maxDiscount, p / 10)
    if (n >= 15) maxDiscount = maxOf(maxDiscount, 2000)
    if (n >= 20) maxDiscount = maxOf(maxDiscount, p / 4)

    println(if (p <= maxDiscount) 0 else p - maxDiscount)
}
