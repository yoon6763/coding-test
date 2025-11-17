package baekjoon.gold.g1.`책 페이지`

lateinit var cnt: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    cnt = IntArray(10)
    var start = 1
    var end = readLine().toInt()
    var ten = 1

    while (start <= end) {
        while (start % 10 != 0 && start <= end) {
            calc(start, ten)
            start++
        }

        while (end % 10 != 9 && start <= end) {
            calc(end, ten)
            end--
        }

        if (start > end) break

        start /= 10
        end /= 10

        repeat(10) {
            cnt[it] += (end - start + 1) * ten
        }

        ten *= 10
    }

    val sb = StringBuilder().let { sb ->
        cnt.forEach { sb.append("$it ") }
        sb
    }

    println(sb)
}

fun calc(x: Int, ten: Int) {
    var x = x

    while (x > 0) {
        cnt[x % 10] += ten
        x /= 10
    }
}