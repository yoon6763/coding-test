package baekjoon.bronze.b1

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val arr = IntArray(1001) { 0 }
    var k = 1
    var i = 1
    while (i <= 1000) {
        var j = 1
        while (j <= k && i <= 1000) {
            arr[i] = k
            i++
            j++
        }
        k++
    }
    println(arr.sliceArray(a..b).sum())
}
