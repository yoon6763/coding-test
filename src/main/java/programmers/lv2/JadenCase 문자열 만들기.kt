package programmers.lv2

fun main() {
    println(solution("for the      last week"))
}

private fun solution(s: String): String {
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