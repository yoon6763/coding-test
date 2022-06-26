package baekjoon.silver.s3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nm = br.readLine().split(" ")
    val n = nm[0].toInt()
    val m = nm[1].toInt()

    val st = StringTokenizer(br.readLine(), " ")
    val nums = Array(n + 1) { 0 }
    nums[1] = st.nextToken().toInt()

    for (i in 2..n) {
        nums[i] = nums[i - 1] + st.nextToken().toInt()
    }

    for (a in 0 until m) {
        val ij = br.readLine().split(" ")
        val i = ij[0].toInt()
        val j = ij[1].toInt()

        println(nums[j] - nums[i - 1])

    }
}