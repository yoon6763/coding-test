package programmers.lv2

fun main() {
    print(solution("aukks", "wbqd", 5))
}

fun solution(s: String, skip: String, index: Int): String {
    val pass = skip.toCharArray()
    val sb = StringBuilder()

    for (c in s) {
        var initial = c
        repeat(index) {
            initial++

            if (initial > 'z') initial -= 26

            while (initial in pass) {
                initial++
                if (initial > 'z') initial -= 26
            }
        }
        sb.append(initial)
    }

    return sb.toString()
}