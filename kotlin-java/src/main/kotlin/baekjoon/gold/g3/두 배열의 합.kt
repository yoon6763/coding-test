package baekjoon.gold.g3

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val T = readLine().toInt()

    // A 배열 세팅
    val n = readLine().toInt()
    var st = StringTokenizer(readLine())
    val a = Array(n) { st.nextToken().toInt() }

    // B 배열 세팅
    val m = readLine().toInt()
    st = StringTokenizer(readLine())
    val b = Array(m) { st.nextToken().toInt() }


    val aList = ArrayList<Int>()
    val bList = ArrayList<Int>()

    for (i in a.indices) {
        var sum = 0

        for (j in i until a.size) {
            sum += a[j]
            aList.add(sum)
        }
    }

    for (i in b.indices) {
        var sum = 0

        for (j in i until b.size) {
            sum += b[j]
            bList.add(sum)
        }
    }

    aList.sort()
    bList.sort()

    var aPtr = 0
    var bPtr = bList.size - 1
    var cnt = 0L

    while (aPtr < aList.size && bPtr >= 0) {
        val sum = aList[aPtr].toLong() + bList[bPtr].toLong()

        // 투 포인터 탐색
        if (sum > T) {
            bPtr--
        } else if (sum < T) {
            aPtr++
        } else {

            // 중복되는 누적합이 계속 있을 수 있음
            val aInitial = aList[aPtr]
            val bInitial = bList[bPtr]
            var aCnt = 0L
            var bCnt = 0L

            // a는 증가
            while (aPtr < aList.size && aList[aPtr] == aInitial) {
                aPtr++
                aCnt++
            }
            // b는 감소
            while (bPtr >= 0 && bList[bPtr] == bInitial) {
                bPtr--
                bCnt++
            }

            cnt += aCnt * bCnt
        }
    }

    println(cnt)
}