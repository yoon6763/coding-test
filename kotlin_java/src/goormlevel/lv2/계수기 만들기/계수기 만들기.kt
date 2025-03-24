package goormlevel.lv2.`계수기 만들기`

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val max = readLine().split(" ").map { it.toInt() }
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()

    val k = readLine().toInt()

    repeat(k) {
        arr[n - 1]++
        if (arr[n - 1] > max[n - 1]) {
            for (i in n - 1 downTo 0) {
                if (arr[i] > max[i]) {
                    arr[i] = 0
                    if (i > 0) {
                        arr[i - 1]++
                    }
                }
            }
        }
    }

    println(arr.joinToString(""))
}