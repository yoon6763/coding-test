package programmers.lv0.원소들의_곱과_합

import kotlin.math.pow

fun solution(num_list: IntArray): Int {
    return if (num_list.reduce { acc, i -> acc * i } < num_list.sum().toDouble().pow(2)) 1 else 0
}