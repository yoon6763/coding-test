package baekjoon.silver.s5

import java.util.*
import kotlin.collections.HashMap


fun main() = with(System.`in`.bufferedReader()) {
    val target = arrayOf("Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex")

    val map = HashMap<String, Int>()
    var cnt = 0

    while (true) {
        try {
            val st = StringTokenizer(readLine())

            while (st.hasMoreTokens()) {
                val act = st.nextToken()
                map[act] = map.getOrDefault(act, 0) + 1
                cnt++
            }
        } catch (e: Exception) {
            break
        }
    }

    val sb = StringBuilder()

    for (act in target) {
        val num = map.getOrDefault(act, 0)
        sb.append("$act $num ${String.format("%.2f", num.toFloat() / cnt)}\n")
    }

    sb.append("Total $cnt 1.00")

    println(sb)
}
// Cc Pt Pt Re Tb Re Cm Cm Re Pt Pt Re Ea Ea Pt Pt Pt Re Re Cb Cb Pt Pt Cb