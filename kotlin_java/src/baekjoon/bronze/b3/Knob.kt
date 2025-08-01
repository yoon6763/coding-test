package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val left = IntArray(n)
    val right = IntArray(n)

    repeat(n) { i ->
        val (l, r) = readln().split(" ").map { it.toInt() }
        left[i] = l
        right[i] = r
    }

    var ans = 0

    for (i in 1..<n) {
        if (left[i] != 0 && left[i] == left[i - 1] ||
            right[i] != 0 && right[i] == right[i - 1] ||
            left[i] != 0 && right[i] != 0 && left[i] == right[i]
        ) ans++
    }
    if (n >= 1 && left[0] != 0 && right[0] != 0 && left[0] == right[0]) ans++
    println(ans)
}
