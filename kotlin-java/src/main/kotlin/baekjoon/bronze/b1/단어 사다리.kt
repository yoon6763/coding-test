package baekjoon.bronze.b1

fun main() {
    while (true) {
        var pre = readln()
        if (pre == "#") break
        var flag = true

        while (true) {
            val cur = readln()
            if (cur == "#") break
            if (!check(pre, cur)) flag = false
            pre = cur
        }

        println(if (flag) "Correct" else "Incorrect")
    }
}

fun check(str1: String, str2: String): Boolean {
    if (str1.length != str2.length) return false
    var cnt = 0
    for (i in str1.indices) if (str1[i] != str2[i]) cnt++
    return cnt == 1
}
