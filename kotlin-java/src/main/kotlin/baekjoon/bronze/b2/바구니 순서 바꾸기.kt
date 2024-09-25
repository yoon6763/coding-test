package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = IntArray(n + 1) { it }
    val arr2 = IntArray(n + 1)

    repeat(m) {
        val (i, j, k) = readLine().split(" ").map { it.toInt() }
        for (a in i..j) arr2[a] = arr[a]
        var idx1 = i
        var idx2 = k

        while (true) {
            arr[idx1++] = arr2[idx2++]
            if (idx2 == j + 1) idx2 = i
            if (idx2 == k) break
        }
    }

    print(arr.slice(1..n).joinToString(" "))
}
