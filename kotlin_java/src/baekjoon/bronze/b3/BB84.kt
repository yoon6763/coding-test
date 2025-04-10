package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val arr = Array(4) { readln().toCharArray() }
    val sb = StringBuilder()

    for (i in 0..<n) {
        if (arr[0][i] == arr[2][i]) {
            if (arr[1][i] == arr[3][i]) {
                sb.append(arr[1][i])
            } else {
                println("htg!")
                return
            }
        }
    }

    println(sb)
}