package baekjoon.bronze.b3

fun main() {
    val arr = readln().split(" ").map(String::toInt)
    val max = arrayOf(100, 100, 200, 200, 300, 300, 400, 400, 500)

    for (i in arr.indices) {
        if (arr[i] > max[i]) {
            println("hacker")
            return
        }
    }

    if (arr.sum() >= 100) println("draw") else println("none")
}