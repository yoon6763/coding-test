package baekjoon.bronze.b1

fun main() {
    var pre = ' '
    var cnt = 0
    var answer = 0

    readln().forEach {
        if (pre + 1 == it) cnt++
        else {
            if (cnt == 3) answer++
            cnt = 1
        }
        pre = it
    }

    if (cnt == 3) answer++
    println(answer)
}
