package baekjoon.silver.s1.행운의문자열

fun main() {
    val word = readln().map { it.code - 'a'.code }
    println(dfs(0, -1, IntArray(27) { i -> word.count { it == i } }, word.size))
}

fun dfs(index: Int, pre: Int, restAlphabet: IntArray, length: Int): Int {
    var count = 0
    if (index == length) return 1

    for (i in 0..26) {
        if (restAlphabet[i] == 0 || pre == i) continue
        restAlphabet[i]--
        count += dfs(index + 1, i, restAlphabet, length)
        restAlphabet[i]++
    }

    return count
}