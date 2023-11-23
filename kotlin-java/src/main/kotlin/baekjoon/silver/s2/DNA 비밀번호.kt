package baekjoon.silver.s2

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (s, p) = readLine().split(" ").map { it.toInt() }
    val str = readLine()

    val st = StringTokenizer(readLine())
    val (needA, needC, needG, needT) = Array(4) { st.nextToken().toInt() }
    var (cntA, cntC, cntG, cntT) = arrayOf(0, 0, 0, 0)

    var ptr = p
    var ans = 0

    repeat(p) {
        when (str[it]) {
            'A' -> cntA++
            'C' -> cntC++
            'G' -> cntG++
            'T' -> cntT++
        }
    }

    if (needA <= cntA && needC <= cntC && needG <= cntG && needT <= cntT) ans++

    while (s > ptr) {
        when (str[ptr]) {
            'A' -> cntA++
            'C' -> cntC++
            'G' -> cntG++
            'T' -> cntT++
        }

        when (str[ptr - p]) {
            'A' -> cntA--
            'C' -> cntC--
            'G' -> cntG--
            'T' -> cntT--
        }

        if (needA <= cntA && needC <= cntC && needG <= cntG && needT <= cntT) ans++
        ptr++
    }
    println(ans)
}