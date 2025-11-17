package baekjoon.gold.g5.캠프준비

lateinit var arr: IntArray
var n = 0
var l = 0
var r = 0
var x = 0

fun main() {
    val nlrx = readln().split(" ").map { it.toInt() }
    n = nlrx[0]
    l = nlrx[1]
    r = nlrx[2]
    x = nlrx[3]
    arr = readln().split(" ").map { it.toInt() }.toIntArray()
    println(solve(0, 0, 0, Int.MAX_VALUE, Int.MIN_VALUE))
}

fun solve(index: Int, selected: Int, sum: Int, min: Int, max: Int): Int {
    return if (index == n) if (sum < l || sum > r || max - min < x) 0 else 1
    else solve(index + 1, selected, sum, min, max) + solve(
        index + 1,
        selected + 1,
        sum + arr[index],
        min.coerceAtMost(arr[index]),
        max.coerceAtLeast(arr[index])
    )
}