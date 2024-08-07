package baekjoon.silver.s5

fun main() {
    val (n, m) = readln().split(" ")
    println(List(n.toInt()){(1+it).toString().count{it==m[0]}}.sum())
}