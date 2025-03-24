package baekjoon.bronze.b3

fun main() {
    val arr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    repeat(readln().toInt()) {
        val (n, l) = readln().split(" ")
        var idx = arr.indexOf(l)

        for (i in 1..n.toInt()) {
            println(arr[idx].toString().repeat(i))
            idx = (idx + 1) % 26
        }
        println()
    }
}