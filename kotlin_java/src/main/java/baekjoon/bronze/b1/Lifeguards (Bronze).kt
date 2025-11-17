package baekjoon.bronze.b1

fun main() {
    val n = readln().toInt()
    val time = IntArray(1001)
    val arr = Array(n) { IntArray(2) }
    var total = 0
    for (i in 0..<n) {
        val (start, end) = readln().split(" ").map { it.toInt() }
        arr[i][0] = start
        arr[i][1] = end
        for (j in arr[i][0]..<arr[i][1]) {
            if (time[j] == 0) {
                total++
            }
            time[j]++
        }
    }
    var cnt = 987654321
    for (i in 0..<n) {
        var c = 0
        for (j in arr[i][0]..<arr[i][1]) {
            if (time[j] > 1) continue
            c++
        }
        cnt = minOf(cnt, c)
    }

    println(total - cnt)
}
