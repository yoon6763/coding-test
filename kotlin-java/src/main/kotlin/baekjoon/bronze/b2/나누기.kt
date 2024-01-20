package baekjoon.bronze.b2

fun main() {
    var (n, f) = List(2) { readln().toInt() }
    n /= 100
    n *= 100
    var ans = 0

    while (n % f != 0) {
        n++
        ans++
    }
    print(if (ans < 10) "0$ans" else ans)
}
