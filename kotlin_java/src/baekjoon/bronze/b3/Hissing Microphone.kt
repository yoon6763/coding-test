package baekjoon.bronze.b3

fun main() {
    val s = readln()
    for (i in 0..<s.length - 1) {
        if (s[i] == 's' && s[i + 1] == 's') {
            println("hiss")
            return
        }
    }
    println("no hiss")
}