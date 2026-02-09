package baekjoon.bronze.b3

fun main() {
    var ans = 0
    repeat(readln().toInt()) {
        for (c in readln()) {
            ans += when (c) {
                'A' -> 4
                'K' -> 3
                'Q' -> 2
                'J' -> 1
                else -> 0
            }
        }
    }
    print(ans)
}
