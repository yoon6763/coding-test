package programmers.lv0.조건에_맞게_수열_변환하기_3

fun solution(arr: IntArray, k: Int): IntArray {
    return (if (k % 2 == 1) arr.map { it * k } else arr.map { it + k }).toIntArray()
}