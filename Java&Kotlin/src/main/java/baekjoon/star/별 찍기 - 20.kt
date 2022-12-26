package baekjoon.star

fun main() {
    val n = readln().toInt()

    repeat(n) {
        if(it % 2 == 0) {
            repeat(n) {
                print("* ")
            }
        } else {
            repeat(n) {
                print(" *")
            }
        }
        println()
    }
}