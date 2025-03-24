package programmers.lv2.예상_대진표

fun solution(n: Int, a: Int, b: Int): Int {

    var a1 = a
    var b1 = b
    var cnt = 0

    do {
        a1 = a1 / 2 + a1 % 2
        b1 = b1 / 2 + b1 % 2
        cnt++
    } while (a1 != b1)

    return cnt
}