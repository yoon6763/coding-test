package programmers.lv2.n2_배열_자르기

fun solution(n: Int, left: Long, right: Long) =
    IntArray((right - left).toInt() + 1) { maxOf((left + it) % n.toLong(), (left + it) / n.toLong()).toInt() + 1 }