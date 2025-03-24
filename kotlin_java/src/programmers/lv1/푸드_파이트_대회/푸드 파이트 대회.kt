package programmers.lv1.푸드_파이트_대회

fun solution(food: IntArray): String {
    val sb = StringBuilder()

    food.forEachIndexed { index, i ->
        sb.append(index.toString().repeat(i / 2))
    }

    return StringBuilder().append(sb).append(0).append(sb.reversed()).toString()
}