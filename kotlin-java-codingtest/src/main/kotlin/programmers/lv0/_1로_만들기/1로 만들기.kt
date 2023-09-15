package programmers.lv0._1로_만들기

fun solution(num_list: IntArray): Int {
    var answer = 0
    num_list.forEach {
        var num = it
        var cnt = 0
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2
            } else {
                num = (num - 1) / 2
            }
            cnt++
        }
        answer += cnt
    }
    return answer
}