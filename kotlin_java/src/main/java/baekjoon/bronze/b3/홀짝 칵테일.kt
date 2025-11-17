package baekjoon.bronze.b3

fun main() {
    var odd = 1
    var even = 1
    var isOddUsed = false
    readln().split(" ").map { it.toInt() }.forEach {
        if (it % 2 == 0) {
            even *= it
        } else {
            odd *= it
            isOddUsed = true
        }
    }
    println(if (isOddUsed) odd else even)
}