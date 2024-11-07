package baekjoon.bronze.b2

fun main() {
    readln()
    val arr = readln().split(" ").map { it.toInt() }
    readln().split(" ").map { it.toInt() }.withIndex().fold(0 to 0) { (total, ans), (index, tmp) ->
        total + arr[index] to if (tmp == 0) ans + arr[index] else ans
    }.let { (total, ans) ->
        println(total)
        println(ans)
    }
}
