package baekjoon.bronze.b3

fun main() {
    readln().toInt()
    val s = readln()
    var ans = 987654321
    "uospc".forEach {
        ans = minOf(ans, s.count { c -> c == it })
    }
    println(ans)
}
