package baekjoon.silver.s4


fun main() = with(System.`in`.bufferedReader()) {

    val (n, k) = readLine().split(" ").map { it.toInt() }

    val q = ArrayList<Int>()
    val result = ArrayList<Int>()

    repeat(n) {
        q.add(it + 1)
    }

    var idx = 0
    repeat(n) {
        idx += k - 1
        idx %= q.size
        result.add(q[idx])
        q.removeAt(idx)
    }

    print("<${result.joinToString(", ")}>")
}