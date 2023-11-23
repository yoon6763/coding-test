package programmers.lv2.연속_부분_수열_합의_개수

fun solution(elements: IntArray): Int {
    val ansSet = mutableSetOf<Int>()
    for (i in elements.indices) {
        var sum = 0
        for (j in elements.indices) {
            sum += elements[(i + j) % elements.size]
            ansSet.add(sum)
        }
    }
    return ansSet.size
}