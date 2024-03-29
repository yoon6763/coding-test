package baekjoon.silver.s1.`에너지 모으기`

var max = 0

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.toMutableList()
    dfs(n, arr, 0)
    println(max)
}

fun dfs(n: Int, arr: MutableList<Int>, sum: Int) {
    if (n == 2) {
        max = maxOf(max, sum)
        return
    }

    for (i in 1..<arr.size - 1) {
        val energy = arr[i - 1] * arr[i + 1]
        val temp = arr[i]
        arr.removeAt(i)
        dfs(n - 1, arr, sum + energy)
        arr.add(i, temp)
    }

}