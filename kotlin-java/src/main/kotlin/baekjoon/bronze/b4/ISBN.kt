package baekjoon.bronze.b4

fun main() {
    val mul = listOf(1, 3)
    var ans = 0
    "9780921418".forEachIndexed { index, c ->
        ans += (c - '0') * mul[index % 2]
    }
    val arr = List(3) { readln().toInt() }
    ans += arr[0] + arr[1] * 3 + arr[2]
    println("The 1-3-sum is $ans")
}