package programmers.lv1.없는_숫자_더하기

fun solution(numbers: IntArray): Int {
    var answer: Int = 0

    for(i in 1..9) {
        if(i !in numbers) {
            answer = answer + i
        }
    }
    return answer
}