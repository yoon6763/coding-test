package programmers.lv0.중앙값_구하기

fun solution(array: IntArray): Int {
    array.sort()
    return array[array.size / 2]
}