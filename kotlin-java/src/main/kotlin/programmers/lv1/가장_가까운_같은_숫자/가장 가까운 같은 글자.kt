package programmers.lv1.가장_가까운_같은_숫자

fun solution(s: String): IntArray {
    val answer = IntArray(s.length) { -1 }

    s.toCharArray().distinct().forEach { findChar ->

        var pre = -1

        s.forEachIndexed { index, c ->
            if (findChar == c) {
                if (pre != -1) {
                    answer[index] = index - pre
                }
                pre = index
            }
        }
    }

    return answer
}