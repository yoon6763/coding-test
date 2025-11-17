package baekjoon.bronze.b3

fun main() {
    readln().split(" ").map { it.toInt() }.forEach { n ->
        for (i in 0..<n - 1) {
            for (j in 0..<i) print(" ")
            print("*")
            for (j in 0..<2 * (n - i - 1) - 1) print(" ")
            println("*")
        }
        for (i in 0..<n - 1) print(" ")
        println("*")
    }
}
