package baekjoon.gold.g5.애너그램

var restChars = IntArray(26)
var anagram = sortedSetOf<String>()
val answer = StringBuilder()
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        restChars.fill(0)
        readLine().forEach { restChars[it - 'a']++ }
        n = restChars.sum()
        anagram.clear()
        solve(0, StringBuilder())
        answer.appendLine(anagram.joinToString("\n"))
    }

    print(answer)
}

fun solve(index: Int, buffer: StringBuilder) {
    if (index == n) {
        anagram.add(buffer.toString())
        return
    }

    for (i in 0..<26) {
        if (restChars[i] == 0) continue
        restChars[i]--
        buffer.append('a' + i)
        solve(index + 1, buffer)
        buffer.deleteCharAt(buffer.length - 1)
        restChars[i]++
    }
}