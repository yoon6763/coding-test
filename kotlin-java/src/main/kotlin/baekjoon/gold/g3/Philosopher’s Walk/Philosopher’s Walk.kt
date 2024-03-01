package baekjoon.gold.g3.`Philosopher’s Walk`

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val result = solve(n, m - 1)
    println("${result.first} ${result.second}")
}

fun solve(n: Int, m: Int): Pair<Int, Int> {
    if (n == 2) {
        return when (m) {
            0 -> Pair(1, 1)
            1 -> Pair(1, 2)
            2 -> Pair(2, 2)
            3 -> Pair(2, 1)
            else -> Pair(0, 0)
        }
    }

    val half = n / 2
    val quarter = m / (half * half)

    return when (quarter) {
        0 -> {
            val p = solve(half, m % (half * half))
            Pair(p.second, p.first)
        }

        1 -> {
            val p = solve(half, m % (half * half))
            Pair(p.first, p.second + half)
        }

        2 -> {
            val p = solve(half, m % (half * half))
            Pair(p.first + half, p.second + half)
        }

        3 -> {
            val p = solve(half, m % (half * half))
            Pair(2 * half - p.second + 1, half - p.first + 1)
        }

        else -> Pair(0, 0) // 예외 처리 필요
    }
}