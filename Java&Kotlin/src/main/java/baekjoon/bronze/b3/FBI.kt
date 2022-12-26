package baekjoon.bronze.b3

fun main() {
    var cnt = 0
    repeat(5) {
        if (readln().contains("FBI")) {
            cnt++
            print("${it + 1} ")
        }
    }
    if (cnt == 0) print("HE GOT AWAY!")
}