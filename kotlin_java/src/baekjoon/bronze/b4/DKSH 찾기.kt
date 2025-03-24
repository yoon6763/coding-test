package baekjoon.bronze.b4

fun main() {
    val str = readln()
    var cnt = 0
    for (i in 0 until str.length - 3) {
        if (str.substring(i, i + 4) == "DKSH") cnt++
    }
    println(cnt)
}
