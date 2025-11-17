package baekjoon.gold.g5.귀찮은해강이

lateinit var parent: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    parent = IntArray(n + 1) { it }

    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        union(a, b)
    }

    var count = 0
    val arr = readLine().split(" ").map { it.toInt() }

    for (i in 0..<n - 1) {
        if (find(arr[i]) != find(arr[i + 1])) count++
    }

    print(count)
}

fun find(x: Int): Int {
    if (parent[x] == x) return x
    parent[x] = find(parent[x])
    return parent[x]
}

fun union(a: Int, b: Int) {
    val (pa, pb) = find(a) to find(b)
    if (pa != pb) parent[pb] = pa
}