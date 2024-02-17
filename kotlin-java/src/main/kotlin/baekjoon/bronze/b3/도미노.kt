package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    var sum = 0
    for (i in 0..n) {
        for (j in i..n) {
            sum += (i + j)
        }
    }
    print(sum)
}
