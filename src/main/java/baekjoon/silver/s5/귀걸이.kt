package baekjoon.silver.s5

import java.io.BufferedReader
import java.io.InputStreamReader

data class Student(var name: String, var cnt: Int)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var cnt = 0
    while (true) {
        cnt++

        val n = br.readLine().toInt()
        if (n == 0) break

        val students = Array(n) { Student("", 0) }

        repeat(n) {
            val name = br.readLine()
            students[it].name = name
        }

        repeat(2 * n - 1) {
            val line = br.readLine().split(" ")
            val idx = line[0].toInt() - 1

            students[idx].cnt++
        }

        for (i in 0 until n) {
            if (students[i].cnt == 1) {
                println("$cnt ${students[i].name}")
                break
            }
        }
    }
}