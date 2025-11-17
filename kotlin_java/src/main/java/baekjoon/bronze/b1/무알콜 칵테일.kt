package baekjoon.bronze.b1

fun main() {
    var (a, b, c) = readln().split(" ").map { it.toDouble() }
    val (needA, needB, needC) = readln().split(" ").map { it.toDouble() }

    val make = minOf(a / needA, b / needB, c / needC)
    a -= make * needA
    b -= make * needB
    c -= make * needC

    println("$a $b $c")
}