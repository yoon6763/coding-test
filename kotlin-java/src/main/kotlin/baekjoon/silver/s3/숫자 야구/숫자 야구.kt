package baekjoon.silver.s3.`숫자 야구`

data class Baseball(val num: String, val strike: Int, val ball: Int)

fun main() = with(System.`in`.bufferedReader()) {
    var cnt = 0

    val baseballs = mutableListOf<Baseball>()
    repeat(readLine().toInt()) {
        val (num, strike, ball) = readLine().split(" ").map { it.toInt() }
        baseballs.add(Baseball(num.toString(), strike, ball))
    }

    outer@ for (i in 123..987) {
        val num = i.toString()
        if (num.length != num.toSet().size || num.contains('0')) continue

        for (j in 0 until baseballs.size) {
            var strike = 0
            var ball = 0

            for (k in 0 until 3) {
                if (num[k] == baseballs[j].num[k]) strike++
                else if (num[k] in baseballs[j].num) ball++
            }

            if (strike != baseballs[j].strike || ball != baseballs[j].ball) continue@outer
        }

        cnt++
    }

    println(cnt)
}