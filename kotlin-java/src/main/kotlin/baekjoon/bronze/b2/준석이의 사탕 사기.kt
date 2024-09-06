package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.sorted()

    var result = 0
    var odd = 0

    for (i in n - 1 downTo 0) {
        if (arr[i] % 2 == 1) {
            if (odd != 0) {
                result += odd + arr[i]
                odd = 0
            } else odd = arr[i]
        } else result += arr[i]
    }

    println(result)
}
