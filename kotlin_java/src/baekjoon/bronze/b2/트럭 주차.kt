package baekjoon.bronze.b2

fun main() {
    val fee = readln().split(" ").map { it.toInt() }.toMutableList()
    fee.add(0, 0)
    val time = Array(101) { 0 }
    repeat(3) {
        val t = readln().split(" ").map { it.toInt() }
        for (i in t[0] until t[1]) time[i]++
    }
    println(time.sumOf {it*fee[it]})
}