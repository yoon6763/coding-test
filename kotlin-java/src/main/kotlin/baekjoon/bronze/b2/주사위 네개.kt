package baekjoon.bronze.b2

fun main() {
    var ans = 0
    repeat(readln().toInt()) {
        val arr = readln().split(" ").map { it.toInt() }.sorted()
        val add = if (arr.all { it == arr[0] }) (50000 + arr[0] * 5000)
        else if (arr[0] == arr[1] && arr[1] == arr[2] || arr[1] == arr[2] && arr[2] == arr[3]) (10000 + arr[1] * 1000)
        else if (arr[0] == arr[1] && arr[2] == arr[3]) (2000 + arr[0] * 500 + arr[2] * 500)
        else if (arr[0] == arr[1]) (1000 + arr[0] * 100)
        else if (arr[1] == arr[2]) (1000 + arr[1] * 100)
        else if (arr[2] == arr[3]) (1000 + arr[2] * 100)
        else (arr[3] * 100)
        ans = maxOf(ans, add)
    }
    println(ans)
}