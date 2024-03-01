package programmers.lv3.`단어 변환`

var ans = Int.MAX_VALUE

fun solution(begin: String, target: String, words: Array<String>): Int {
    dfs(begin, target, words, Array(words.size) { false }, 0)
    return if (ans == Int.MAX_VALUE) 0 else ans
}


fun dfs(nowWord: String, target: String, words: Array<String>, visited: Array<Boolean>, depth: Int) {
    if (nowWord == target) {
        ans = minOf(ans, depth)
        return
    }

    if (depth >= ans) return

    nextWord@ for (i in words.indices) {
        if (visited[i]) continue

        var diff = 0
        for (j in words[i].indices) {
            if (words[i][j] != nowWord[j]) {
                diff++
                if (diff > 1) continue@nextWord
            }
        }

        visited[i] = true
        dfs(words[i], target, words, visited, depth + 1)
        visited[i] = false
    }
}