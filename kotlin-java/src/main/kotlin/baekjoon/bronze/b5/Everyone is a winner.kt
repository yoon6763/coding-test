package baekjoon.bronze.b5

fun main() {
    val (n,m) = readLine()!!.split(" ").map { it.toInt() }
    println(if(n % m == 0) "Yes" else "No")
}
