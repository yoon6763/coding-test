package baekjoon.silver.s5

fun main() {
    var money = readln().toInt()
    var cnt = 0
    while (money > 0) {
        money -= if (money % 5 == 0) 5 else 2
        cnt++
    }
    if (money == 0) println(cnt) else println(-1)
}