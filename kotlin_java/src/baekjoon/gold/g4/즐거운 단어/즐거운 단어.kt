package baekjoon.gold.g4.`즐거운 단어`

lateinit var word: CharArray
val vowels = charArrayOf('A', 'E', 'I', 'O', 'U')
var ans = 0L
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    word = readLine().toCharArray()
    n = word.size

    dfs(0, 0, 0, false, 1L)

    println(ans)
}

fun dfs(depth: Int, continuousVowels: Int, continuousConsonants: Int, isIncludeL: Boolean, sum: Long) {
    if (continuousVowels >= 3 || continuousConsonants >= 3) {
        return
    }

    if (depth == n) {
        if (isIncludeL) ans += sum
        return
    }

    if (word[depth] != '_') {
        if (word[depth] in vowels) dfs(depth + 1, continuousVowels + 1, 0, word[depth] == 'L' || isIncludeL, sum)
        else dfs(depth + 1, 0, continuousConsonants + 1, word[depth] == 'L' || isIncludeL, sum)
        return
    }

    dfs(depth + 1, continuousVowels + 1, 0, isIncludeL, sum * 5L)
    dfs(depth + 1, 0, continuousConsonants + 1, isIncludeL, sum * 20L)
    dfs(depth + 1, 0, continuousConsonants + 1, true, sum)
}