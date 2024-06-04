package baekjoon.bronze.b2

fun main() {
    val ans1 = ArrayList<Int>()
    val ans2 = ArrayList<Pair<String, Int>>()
    repeat(3) {
        val (solve, year, nickname) = readln().split(" ")
        ans1.add(year.toInt() % 100)
        ans2.add(Pair(nickname, solve.toInt()))
    }
    println(ans1.sorted().joinToString(""))
    println(ans2.sortedBy { -it.second }.joinToString("") { it.first[0].toString() })
}