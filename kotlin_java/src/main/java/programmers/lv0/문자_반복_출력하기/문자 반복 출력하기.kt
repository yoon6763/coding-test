package programmers.lv0.문자_반복_출력하기

fun solution(my_string: String, n: Int): String {
    var result = ""
    for(ch in my_string) {
        repeat(n) {
            result += ch
        }
    }

    return result
}