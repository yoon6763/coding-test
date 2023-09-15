package programmers.lv0.글자_지우기

fun solution(my_string: String, indices: IntArray): String {
    val answer = my_string.toCharArray()
    indices.forEach {
        answer[it] = ' '
    }
    return answer.filter { it != ' ' }.joinToString("")
}