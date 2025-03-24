package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val rate = arrayOf(0, 0)
    repeat(n) {
        rate[readLine().toInt()]++
    }

    println(if (rate[0] > rate[1]) "Junhee is not cute!" else "Junhee is cute!")
}