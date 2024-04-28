package baekjoon.bronze.b4

fun main() {
    readln()
    repeat(3) {
        if ("7" !in readln().split(" ")) {
            println(0)
            return
        }
    }
    println(777)
}