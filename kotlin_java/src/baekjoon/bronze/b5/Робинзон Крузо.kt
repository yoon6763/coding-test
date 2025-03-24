package baekjoon.bronze.b5

fun main() {
    var n = readln().toInt()
    while (n >= 5) {
        n -= 5
        print("V")
    }
    print("I".repeat(n))
}