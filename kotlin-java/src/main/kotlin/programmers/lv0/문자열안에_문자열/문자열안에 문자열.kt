package programmers.lv0.문자열안에_문자열

fun solution(str1: String, str2: String): Int {
    return if(str2 in str1) 1 else 2
}