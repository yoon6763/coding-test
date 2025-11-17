package baekjoon.bronze.b3

fun main() {
    val prices = readln().split(" ").map { it.toLong() }
    val arr = readln().split(" ").map { it.toLong() }

    var ans = 0L

    listOf(
        listOf(0, 1, 2),
        listOf(0, 2, 1),
        listOf(1, 0, 2),
        listOf(1, 2, 0),
        listOf(2, 0, 1),
        listOf(2, 1, 0)
    ).forEach { p ->
        ans = ans.coerceAtLeast(
            prices[p[0]] * arr[0] +
                    prices[p[1]] * arr[1] +
                    prices[p[2]] * arr[2]
        )
    }

    println(ans)
}
