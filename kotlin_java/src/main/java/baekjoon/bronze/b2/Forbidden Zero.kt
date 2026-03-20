package baekjoon.bronze.b2

fun main() {
    var n = readln().toLong()
    while (true) {
        n++
        if ('0' in n.toString()) continue
        println(n)
        break
    }
}