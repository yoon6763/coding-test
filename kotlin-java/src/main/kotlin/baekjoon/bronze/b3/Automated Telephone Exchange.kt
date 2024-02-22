package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    var cnt = 0
    repeat(100) { i ->
        repeat(100) { j ->
            if(n - i - j == 0) {
                cnt++
            }
        }
    }

    println(cnt)
}