package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val arr = Array(n) { it + 1 }

    outer@ for (i in arr[n - 1]..1000) {
        var flag = true
        for (j in 2..i / 2) {
            if (i % j == 0) {
                flag = false
                break
            }
        }
        if (flag) {
            arr[n - 1] = i
            break@outer
        }
    }

    print("$n\n${arr.joinToString(" ")}")
}