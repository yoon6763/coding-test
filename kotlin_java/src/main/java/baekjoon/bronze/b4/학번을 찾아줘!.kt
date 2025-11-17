package baekjoon.bronze.b4

fun main() {
    var ans = 0

    val t = readln().toInt()
    val arr = readln().split(" ").map(String::toInt).toMutableList()
    while (arr.size < 5) arr.add(0)

    ans += if (arr[0] > arr[2]) (arr[0] - arr[2]) * 508 else (arr[2] - arr[0]) * 108
    ans += if (arr[1] > arr[3]) (arr[1] - arr[3]) * 212 else (arr[3] - arr[1]) * 305
    if (arr[4] > 0) ans += arr[4] * 707

    println(ans * 4763)
}
