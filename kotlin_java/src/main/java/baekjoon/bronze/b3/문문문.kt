package baekjoon.bronze.b3

fun main() {
    val n = readln().trim().toLong()
    var first = readln().trim().toLong()

    if (n > 5) {
        println("Love is open door")
        return
    }
    for (i in 0..<n - 1) {
        if (first == 0L) {
            println(1)
            first = 1
        } else {
            println(0)
            first = 0
        }
    }
}
