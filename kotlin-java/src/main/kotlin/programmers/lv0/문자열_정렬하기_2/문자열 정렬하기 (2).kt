package programmers.lv0.문자열_정렬하기_2

fun solution(my_string: String): String {
    return my_string.lowercase().toCharArray().sorted().joinToString("")
}