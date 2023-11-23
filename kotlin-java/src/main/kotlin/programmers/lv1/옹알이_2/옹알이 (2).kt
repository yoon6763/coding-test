package programmers.lv1.옹알이_2

fun solution(babbling: Array<String>): Int {
    var ans = 0
    val keywords = arrayOf("aya", "ye", "woo", "ma")

    babbling.forEach { targetWord ->
        val targetWordList = targetWord.toMutableList()
        var idx = 0
        var pre = ""

        next@ while (targetWordList.isNotEmpty()) {
            for (i in 0 until 4) {
                if (targetWordList.size < keywords[i].length) continue
                if (targetWordList.subList(0, keywords[i].length) == keywords[i].toList()) {
                    if (pre == keywords[i]) break@next
                    targetWordList.subList(0, keywords[i].length).clear()
                    idx += keywords[i].length
                    pre = keywords[i]
                    continue@next
                }
            }

            break@next
        }

        if (targetWordList.isEmpty()) ans++
    }

    return ans
}