package programmers.lv0.`모음_제거 `

fun solution(my_string: String): String {
    return my_string.toList().filter { it !in arrayOf('a','e','i','o','u') }.joinToString("")
}