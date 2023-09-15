package programmers.lv0.가까운_수

fun solution(array: IntArray, n: Int): Int {
    var answer = 0
    var min = Int.MAX_VALUE

    for (i in array.indices) {
        val diff = Math.abs(array[i] - n)
        if (diff < min) {
            min = diff
            answer = array[i]
        } else if (diff == min) {
            if (array[i] < answer) {
                answer = array[i]
            }
        }
    }
    return answer
}