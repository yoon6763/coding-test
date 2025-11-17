package baekjoon.bronze.b2

fun main() {
    val count = Array(10) { 0 }
    (readln().toLong() * readln().toLong() * readln().toLong()).toString().forEach {
        count[it - '0']++
    }
    count.forEach {
        println(it)
    }
}