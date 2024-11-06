package baekjoon.bronze.b2

fun main() {
    readln()
    val (total, ans) = readln().split(" ").map { it.toInt() }.withIndex().fold(0 to 0) { (total, ans), (index, tmp) ->
        val arr = readln().split(" ").map { it.toInt() }
        total + arr[index] to if (tmp == 0) ans + arr[index] else ans
    }
    println(total)
    println(ans)
}
