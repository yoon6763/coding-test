package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val arr = BooleanArray(26)

    repeat(n) {
        val title = readln()
        val first = title[0] - 'A'
        arr[first] = true
    }

    var ans = 0
    for (i in 0 until 26) {
        if (arr[i]) ans++ else break
    }

    println(ans)
}