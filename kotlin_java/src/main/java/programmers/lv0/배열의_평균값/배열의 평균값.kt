package programmers.lv0.배열의_평균값

fun solution(numbers: IntArray): Double {
    var sum = 0.0
    for(n in numbers){
        sum += n
    }
    return sum / numbers.size
}