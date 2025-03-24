package programmers.lv1.크기가_작은_부분문자열

fun main() {

}

fun solution(t: String, p: String): Int {
    val intP = p.toLong()
    var cnt = 0

    for (i in 0..t.length - p.length) {
        val t1 = t.substring(i, i + p.length)
        if (t1.toLong() <= intP) cnt++
    }

    return cnt
}