package programmers.lv3.`금과 은 운반하기`

fun solution(a: Int, b: Int, g: IntArray, s: IntArray, w: IntArray, t: IntArray): Long {
    var answer: Long = -1
    var left: Long = 1
    var right = (10e9 * 2 * 10e5 * 2).toLong()

    while (left <= right) {
        val mid = (left + right) / 2

        var gold = 0L
        var silver = 0L
        var sum = 0L
        for (i in g.indices) {
            val weight = w[i]
            val time = t[i]

            var cnt = mid / (time * 2)
            if (mid % (time * 2) >= time) cnt++

            gold += Math.min(g[i].toLong(), weight * cnt)
            silver += Math.min(s[i].toLong(), weight * cnt)
            sum += Math.min((g[i] + s[i]).toLong(), weight * cnt)
        }

        if (gold >= a && silver >= b && sum >= a + b) {
            answer = mid
            right = mid - 1
        } else {
            left = mid + 1
        }
    }

    return answer
}