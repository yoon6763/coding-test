package baekjoon.bronze.b4

fun main() {
    println("Gnomes:")
    repeat(readln().toInt()) {
        val arr = readln().split(" ").map { it.toInt() }
        val sorted = arr.sorted()
        val reversed = arr.sortedDescending()
        if(arr.joinToString() == sorted.joinToString() || arr.joinToString() == reversed.joinToString()) {
            println("Ordered")
        } else {
            println("Unordered")
        }
    }
}