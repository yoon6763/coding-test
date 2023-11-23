package baekjoon.bronze.b2

fun main() {
    var cnt = 0
    var height = 0
    val n = readln().toInt()
    val arr = Array(n) { readln().toInt() }.reversed()

    repeat(n) {
        if (arr[it] > height) {
            height = arr[it]
            cnt++
        }
    }
    println(cnt)
}