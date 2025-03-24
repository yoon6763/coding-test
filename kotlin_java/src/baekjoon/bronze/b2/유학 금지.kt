package baekjoon.bronze.b2

fun main() {
    var s = readln()
    "CAMBRIDGE".forEach { s=s.replace(it.toString(), "") }
    println(s)
}