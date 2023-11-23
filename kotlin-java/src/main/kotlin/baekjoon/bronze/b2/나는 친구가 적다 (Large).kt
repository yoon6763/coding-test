package baekjoon.bronze.b2


fun main() = with(System.`in`.bufferedReader()) {
    val text = readLine().replace("[0-9]".toRegex(), "")
    val target = readLine()
    val sb = StringBuilder()

    val pi = IntArray(target.length)
    var j = 0
    for (i in 1 until target.length) {
        while (j > 0 && target[i] != target[j]) {
            j = pi[j - 1]
        }
        if (target[i] == target[j]) {
            pi[i] = ++j
        }
    }
    j = 0
    var isTrue = false
    for (i in text.indices) {
        while (j > 0 && target[j] != text[i]) {
            j = pi[j - 1]
        }
        if (target[j] == text[i]) {
            ++j
            if (j == target.length) {
                isTrue = true
                break
            }
        }
    }
    if (isTrue) sb.append(1) else sb.append(0)
    println(sb)
}