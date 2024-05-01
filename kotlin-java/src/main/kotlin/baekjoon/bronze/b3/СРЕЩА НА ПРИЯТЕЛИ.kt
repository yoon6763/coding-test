package baekjoon.bronze.b3

fun main() {
    val (l1, r1, l2, r2, k) = readln().trim().split(" ").map { it.toInt() }
    val alice = BooleanArray(50001) { false }
    val bob = BooleanArray(50001) { false }

    for (i in l1..r1) {
        alice[i] = true
    }

    for (i in l2..r2) {
        bob[i] = true
    }

    bob[k] = false
    var cnt = 0
    for (i in 1..50000) {
        if (alice[i] && bob[i]) {
            cnt++
        }
    }

    println(cnt)
}