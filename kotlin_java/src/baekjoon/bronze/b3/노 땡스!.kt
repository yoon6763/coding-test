package baekjoon.bronze.b3

fun main() {
    readln()
    val arr = readln().split(" ").map { it.toInt() }
    var (sum, pre) = List(2) { arr[0] }

    for (i in 1..<arr.size) {
        if (arr[i] - pre == 1) {
            pre = arr[i]
        } else {
            sum += arr[i]
            pre = arr[i]
        }
    }

    println(sum)
}