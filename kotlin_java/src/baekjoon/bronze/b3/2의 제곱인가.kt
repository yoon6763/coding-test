package baekjoon.bronze.b3

fun main() {
    val goal = readln().toLong()
    var n = 1L

    while (goal >= n) {
        if(n == goal) {
            println(1)
            return
        }
        n *= 2
    }
    println(0)
}