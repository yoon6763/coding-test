package programmers.lv0.숨어있는_숫자의_덧셈_1

fun solution(my_string: String): Int {
    return my_string.toList().filter { it.isDigit() }.sumOf { it.digitToInt() }
}