package baekjoon.bronze.b3

fun main() {
    while (true) {
        val n = readln().trim().toInt()
        if (n == -1) break

        val list = mutableListOf<Pair<Int, Int>>()
        repeat(n) {
            val (speed, time) = readln().trim().split(" ").map { it.toInt() }
            list.add(Pair(speed, time))
        }

        var res = list[0].first * list[0].second
        for (i in 1 until n) {
            res += list[i].first * (list[i].second - list[i - 1].second)
        }

        println("$res miles")
    }
}
