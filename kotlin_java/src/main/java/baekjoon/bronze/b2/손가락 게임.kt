package baekjoon.bronze.b2

fun main() {
    val (a, b) = readln().split(" ")
    val special = setOf("0", "2", "5")

    when {
        a in special && b !in special -> println(">")
        a !in special && b in special -> println("<")
        (a == "0" && b == "2") || (a == "2" && b == "5") || (a == "5" && b == "0") -> println(">")
        (a == "2" && b == "0") || (a == "5" && b == "2") || (a == "0" && b == "5") -> println("<")
        else -> println("=")
    }
}
