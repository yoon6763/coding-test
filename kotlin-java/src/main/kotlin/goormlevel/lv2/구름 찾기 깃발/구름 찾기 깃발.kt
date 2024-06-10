package goormlevel.lv2.`구름 찾기 깃발`

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map(String::toInt)
    val arr = Array(n) { readLine().split(" ") }
    var ans = 0

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (arr[i][j] == "0") {
                var cnt = 0

                for (x in arrayOf(i - 1, i, i + 1)) {
                    for (y in arrayOf(j - 1, j, j + 1)) {
                        if (x in 0 until n && y in 0 until n && arr[x][y] == "1") cnt++
                    }
                }

                if (cnt == k) ans++
            }
        }
    }

    println(ans)
}