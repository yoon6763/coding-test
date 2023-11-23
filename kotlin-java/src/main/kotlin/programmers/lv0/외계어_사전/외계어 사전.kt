package programmers.lv0.외계어_사전

fun solution(spell: Array<String>, dic: Array<String>): Int {
    dic.forEach { word ->

        var cnt = 0

        spell.forEach { char ->
            if (word.count { it == char[0] } == 1) cnt++
        }

        if (cnt == spell.size) return 1
    }

    return 2
}