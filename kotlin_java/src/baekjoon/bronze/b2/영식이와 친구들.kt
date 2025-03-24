package baekjoon.bronze.b2

fun main() {
    val (n, m, l) = readln().split(" ").map { it.toInt() }
    val arr = IntArray(n)
    var answer = 0
    var temp = 0
    while (true) {
        if (arr[temp] % 2 == 1) {
            temp = (temp + l) % n
            arr[temp]++
            answer++
        } else if (arr[temp] % 2 == 0) {
            temp = ((temp - l) + n) % n
            arr[temp]++
            answer++
        }
        if (arr[temp] == m) break
    }
    print(answer - 1)
}
