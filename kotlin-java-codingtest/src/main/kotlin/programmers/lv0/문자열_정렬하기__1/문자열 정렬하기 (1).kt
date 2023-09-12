package programmers.lv0.문자열_정렬하기__1

fun solution(my_string: String): IntArray {
    return my_string.filter { it.isDigit() }.toList().sorted().map { it.digitToInt() }.toIntArray()
}