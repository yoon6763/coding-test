package programmers.lv2.모음_사전

var cnt = 0
var ans = 0
val aeiou = arrayOf('A','E','I','O','U')

fun solution(word: String): Int {
    backTracking(word, 0, "")

    return ans
}

fun backTracking(word:String, idx: Int, curStr:String) {
    if(word == curStr) {
        ans = cnt
        return
    }

    if(idx == 5) return

    for(i in 0 until 5) {
        cnt++
        backTracking(word, idx + 1, curStr + aeiou[i])
    }
}