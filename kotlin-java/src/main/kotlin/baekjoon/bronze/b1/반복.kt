package baekjoon.bronze.b1

fun main() {
    val str = readln()
    var ans = 1
    var pre = str[0]
    for (i in 1..<str.length) {
        val cur = str[i]
        if (cur - 'a' <= pre - 'a') ans++
        pre = cur
    }
    println(ans)
}
