package programmers.lv0.숨어있는_숫자의_덧셈__2

import java.util.StringTokenizer

fun solution(my_string: String): Int {
    val st = StringTokenizer(my_string, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")
    return Array(st.countTokens()) { st.nextToken().toInt() }.sum()
}