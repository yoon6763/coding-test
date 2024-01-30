package programmers.lv0.`옹알이 (1)`

fun solution(babbling: Array<String>): Int {
    var answer: Int = 0

    babbling.forEach { word ->
        var word = word
        val ableWords = arrayOf("aya", "woo", "ye", "ma")
        val isUsed = BooleanArray(ableWords.size)

        outer@ while (true) {
            for (i in ableWords.indices) {
                if (word.startsWith(ableWords[i]) && !isUsed[i]) {
                    word = word.removePrefix(ableWords[i])
                    isUsed[i] = true
                    continue@outer
                }
            }
            break
        }

        if (word == "") answer++
    }

    return answer
}