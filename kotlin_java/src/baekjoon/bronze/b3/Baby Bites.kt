package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ")
    for (i in 0..<n) {
        if (arr[i] == "mumble" || arr[i] == (i + 1).toString()) continue
        println("something is fishy")
        return
    }
    println("makes sense")
}