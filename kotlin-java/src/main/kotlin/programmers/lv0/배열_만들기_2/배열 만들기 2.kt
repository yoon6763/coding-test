package programmers.lv0.배열_만들기_2

fun solution(l: Int, r: Int): IntArray {
    val answer = mutableListOf<Int>()
    for (i in l..r) if (i.toString().all { it == '0' || it == '5' }) answer.add(i)
    return if (answer.isEmpty()) intArrayOf(-1) else answer.toIntArray()
}
