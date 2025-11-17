package baekjoon.silver.s4.`GCD 합`

import java.util.StringTokenizer

fun main() {
    repeat(readln().toInt()) {
        val st = StringTokenizer(readln())
        val n = st.nextToken().toInt()
        val inputs = Array(n) { st.nextToken().toLong() }
        var answer = 0L

        for (i in 0..<inputs.size - 1) {
            for (j in i + 1..<inputs.size) {
                answer += gcd(inputs[i], inputs[j])
            }
        }
        println(answer)
    }
}

fun gcd(a: Long, b: Long): Long {
    var a = a
    var b = b
    while (b > 0) {
        val temp = b
        b = a % b
        a = temp
    }
    return a
}
