package programmers.lv2.JadenCase_문자열_만들기

fun solution(s: String): String {
    var space = true
    var result = ""
    s.forEach {
        if (it == ' ') {
            result += it
            space = true
        } else if (space && it.isDigit()) {
            result += it
            space = false
        } else if (space) {
            result += it.uppercase()
            space = false
        } else {
            result += it.lowercase()
        }
    }

    return result
}