package baekjoon.bronze.b1

fun main() {
    var a = 1
    for (i in 1..readln().toInt()) {
        a *= i
    }
    println(a)
}
