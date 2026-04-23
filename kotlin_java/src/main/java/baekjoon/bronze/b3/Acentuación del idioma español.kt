package baekjoon.bronze.b3

fun main() {
    val s = readln()
    val vowels = setOf('a', 'e', 'i', 'o', 'u')
    val vowelPos = mutableListOf<Int>()

    for (i in s.indices) {
        if (s[i] in vowels) vowelPos.add(i + 1)
    }

    if (vowelPos.isEmpty()) {
        println(-1)
        return
    }

    val last = s.last()
    val isSpecialEnd = last == 'a' || last == 'e' || last == 'i' ||
            last == 'o' || last == 'u' || last == 'n' || last == 's'

    println(if (isSpecialEnd) if (vowelPos.size < 2) -1 else vowelPos[vowelPos.size - 2] else vowelPos.last())
}