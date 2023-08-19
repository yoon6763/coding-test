package baekjoon.bronze.b2

fun main() {
    var n = readln()
    var sum = n.toLong()

    repeat(n.length - 1) {
        n = n.substring(1) + n[0]
        sum += n.toLong()
    }
    println(sum)
}