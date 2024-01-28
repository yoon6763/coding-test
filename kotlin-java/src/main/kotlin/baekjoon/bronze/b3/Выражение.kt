package baekjoon.bronze.b3

fun main() {
    readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    val sum = arr.sum()
    arr.forEachIndexed { index, it ->
        if (sum - it == it) {
            println(index + 1)
            return
        }
    }
}