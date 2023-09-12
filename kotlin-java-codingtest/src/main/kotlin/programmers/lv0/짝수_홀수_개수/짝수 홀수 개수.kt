package programmers.lv0.짝수_홀수_개수

fun solution(num_list: IntArray): IntArray {
    return intArrayOf(num_list.count{it % 2 == 0}, num_list.count{it % 2 == 1})
}