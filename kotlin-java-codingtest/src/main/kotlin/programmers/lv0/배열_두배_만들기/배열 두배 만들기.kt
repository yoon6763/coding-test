package programmers.lv0.배열_두배_만들기

fun solution(numbers: IntArray): IntArray {
    return numbers.map {it -> it * 2}.toIntArray()
}