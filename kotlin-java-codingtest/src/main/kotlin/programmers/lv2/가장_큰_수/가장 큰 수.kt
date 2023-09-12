package programmers.lv2.가장_큰_수

import java.util.*

fun solution(numbers: IntArray): String {
    val strNums = numbers.map { it.toString() }.toTypedArray()

    Arrays.sort(strNums) { o1, o2 -> (o2+o1).compareTo(o1+o2)}

    if(strNums[0] == "0") return "0"

    val sb = StringBuilder()

    for(str in strNums) {
        sb.append(str)
    }


    return sb.toString()
}