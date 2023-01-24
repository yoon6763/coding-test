package baekjoon.gold.g3.순회강연

import java.util.*

data class Lecture(val price: Int, var day: Int)

fun main() = with(System.`in`.bufferedReader()) {

    val pq = PriorityQueue<Lecture> { o1, o2 ->
        o2.price - o1.price
    }

    repeat(readLine().toInt()) {
        // 돈, 기간 순으로 주어짐
        val st = StringTokenizer(readLine())
        pq.offer(Lecture(st.nextToken().toInt(), st.nextToken().toInt()))
    }

    // 강의가 잡혀있는지 체크
    val days = Array(10001) { false }

    var sum = 0L

    while (pq.isNotEmpty()) {
        val target = pq.poll()
        // 강의가 잡혀있지 않다면
        if (!days[target.day]) {
            days[target.day] = true
            sum += target.price
        } else {
            // 강의가 잡혀있다면
            var day = target.day

            // 이전일 중 가장 가까운 날을 찾음
            while (day > 0) {
                if (!days[day]) {
                    days[day] = true
                    sum += target.price
                    break
                } else {
                    day--
                }
            }
        }
    }

    println(sum)
}
