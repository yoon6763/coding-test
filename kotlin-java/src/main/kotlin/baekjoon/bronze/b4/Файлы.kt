package baekjoon.bronze.b4

fun main() {
    val arr = Array(readln().toInt()) { readln() }
    generateSequence { readlnOrNull() }
        .take(readln().toInt())
        .map { it.split(" ").map(String::toInt) }
        .forEach { (l, r) -> (l - 1..<r).forEach { println(arr[it]) } }
}