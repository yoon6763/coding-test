package baekjoon.bronze.b1

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val a = readln().split(" ").map { it.toInt() }.toMutableList()

    fun solve(lst: MutableList<Int>, k: Int) {
        var cnt = 0

        for (i in 1 until lst.size) {
            var loc = i - 1
            val newItem = lst[i]

            while (loc >= 0 && newItem < lst[loc]) {
                cnt++
                lst[loc + 1] = lst[loc]
                loc--

                if (cnt == k) {
                    println(lst[loc + 1])
                    return
                }
            }

            if (loc + 1 != i) {
                cnt++
                lst[loc + 1] = newItem

                if (cnt == k) {
                    println(lst[loc + 1])
                    return
                }
            }
        }

        println(-1)
    }

    solve(a, k)
}
