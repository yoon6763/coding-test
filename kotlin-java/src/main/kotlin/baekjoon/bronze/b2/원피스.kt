package baekjoon.bronze.b2

fun main() {
    val str = readln()
    val target = readln()
    var cnt = 0
    for (i in 0..str.length - target.length) {
        if (str.substring(i, i + target.length) == target) {
            cnt++
        }
    }
    print(cnt)
}