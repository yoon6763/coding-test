package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val arr = IntArray(n) { readln().toInt() }

    var i = 0
    while (i < n) {
        val base = arr[i]
        var found = false

        for (j in i + 1 until n) {
            if (arr[j] % base != 0) continue
            println(arr[j])
            i = j + 1
            found = true
            break
        }

        if (!found) break
    }
}