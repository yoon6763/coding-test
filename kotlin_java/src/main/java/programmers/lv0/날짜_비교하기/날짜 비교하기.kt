package programmers.lv0.날짜_비교하기

import java.time.LocalDate


fun solution(date1: IntArray, date2: IntArray): Int {
    val d1 = LocalDate.of(date1[0], date1[1], date1[2])
    val d2 = LocalDate.of(date2[0], date2[1], date2[2])

    return if (d1.isBefore(d2)) 1 else 0
}