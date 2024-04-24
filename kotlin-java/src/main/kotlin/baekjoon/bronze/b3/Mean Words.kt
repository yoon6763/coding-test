package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val arr = Array(n) { readln() }
    repeat(arr.maxOf { it.length }) { index ->
        var sum = 0
        var cnt = 0
        repeat(n) {
            if (arr[it].length > index) {
                sum += arr[it][index].code
                cnt++
            }
        }
        print((sum / cnt ).toChar())
    }
}