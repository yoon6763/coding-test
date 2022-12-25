package baekjoon.star

fun main() {
    val n = readln().toInt()

    repeat(n) {
        if (n == it + 1) {
            repeat(n * 2 - 1) {
                print("*")
            }
        } else {
            repeat(n - it - 1) {
                print(" ")
            }
            print("*")
            if (it != 0) {
                repeat(it * 2 - 1) {
                    print(" ")
                }
                print("*")
            }
            println()
        }
    }
}