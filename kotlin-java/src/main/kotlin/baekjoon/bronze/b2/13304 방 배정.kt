package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val room = Array(2) { Array(7) { 0 } }
    repeat(n) {
        val (gender, grade) = readLine().split(" ").map { it.toInt() }
        room[gender][grade]++
    }

    var ans = room[0][1] + room[1][1] + room[0][2] + room[1][2]
    ans = ans / k + if (ans % k == 0) 0 else 1

    for (gender in 0..1) {
        for (grade in 3..5 step 2) {
            val num = room[gender][grade] + room[gender][grade + 1]
            ans += num / k + if (num % k == 0) 0 else 1
        }
    }

    println(ans)
}