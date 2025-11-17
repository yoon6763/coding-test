package baekjoon.bronze.b4

fun main() {
    val (x, y) = readln().split(" ").map { it.toInt() }
    val a = 100 - x
    val b = 100 - y
    val c = 100 - (a + b)
    val d = a * b
    val q = d / 100
    val r = d % 100

    println("$a $b $c $d $q $r")
    println("${c + q} $r")
}
