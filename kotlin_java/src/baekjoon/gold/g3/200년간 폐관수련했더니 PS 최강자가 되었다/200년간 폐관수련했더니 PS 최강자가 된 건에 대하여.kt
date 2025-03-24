package baekjoon.gold.g3.`200년간 폐관수련했더니 PS 최강자가 되었다`

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    var maxPrizeMoney = 0L
    var flag = 1
    var sum = 0L

    for (i in 0 until n) {
        val (upperLimit, prizeMoney) = StringTokenizer(readLine()).let { st -> List(2) { st.nextToken().toLong() } }

        if (sum <= upperLimit) {
            sum += prizeMoney
            maxPrizeMoney = maxOf(maxPrizeMoney, prizeMoney)
            continue
        }

        if (sum - maxPrizeMoney > upperLimit || maxPrizeMoney < prizeMoney) {
            flag--
        } else {
            sum -= maxPrizeMoney
            sum += prizeMoney
            flag--
        }

        if (flag < 0) {
            println("Zzz")
            return@with
        }
    }

    println("Kkeo-eok")
}