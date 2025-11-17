package baekjoon.silver.s5

fun main() {
    val n = readln().toInt()
    val arr = Array(n) { readln() }
    val idx = arr.indexOf("?")
    val first = if (idx == 0) ' ' else arr[idx - 1].last()
    val last = if (idx == n - 1) ' ' else arr[idx + 1].first()

    print(List(readln().toInt()) { readln() }.first {
        it !in arr && (first == ' ' || it.first() == first) && (last == ' ' || it.last() == last)
    })
}