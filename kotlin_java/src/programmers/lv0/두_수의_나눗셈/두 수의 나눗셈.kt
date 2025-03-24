package programmers.lv0.두_수의_나눗셈

fun solution(num1: Int, num2: Int): Int {
    return ((num1.toDouble() / num2.toDouble()) * 1000).toInt()
}