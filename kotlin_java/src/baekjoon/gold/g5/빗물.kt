package baekjoon.gold.g5

fun main() = with(System.`in`.bufferedReader()) {
    val (h, w) = readLine().split(" ").map(String::toInt)
    val blockHeights = readLine().split(" ").map(String::toInt).toIntArray()

    var ans = 0

    for (i in 1..<w - 1) {
        var left = 0
        var right = 0

        for (j in 0..<i) {
            left = maxOf(left, blockHeights[j])
        }

        for (j in i + 1..<w) {
            right = maxOf(right, blockHeights[j])
        }

        val height = minOf(left, right)
        ans += maxOf(0, height - blockHeights[i])
    }

    println(ans)
}