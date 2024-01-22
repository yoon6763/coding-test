package baekjoon.bronze.b4

fun main() {
    val str = readln()

    var ans = ""
    var idx = 0
    while (true) {
        if (idx == str.length - 1) break
        ans += str[idx]
        idx += str[idx] - 'A' + 1
    }

    ans += str[str.length - 1]
    println(ans)
}
