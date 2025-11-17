package programmers.lv0.배열_원소의_길이

fun solution(strlist: Array<String>): IntArray {
    return strlist.map{it.length}.toIntArray()
}