package baekjoon.silver.s4

import java.util.*

private data class Student(var name: String, var kor: Int, var eng: Int, var math: Int)

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()

    val students = Array(n) { Student("", 0, 0, 0) }

    repeat(n) {
        val st = StringTokenizer(br.readLine())
        students[it].name = st.nextToken()
        students[it].kor = st.nextToken().toInt()
        students[it].eng = st.nextToken().toInt()
        students[it].math = st.nextToken().toInt()
    }

    // 디폴트가 오름차순
    students.sortWith(
        compareBy(
            { -it.kor }, // -를 붙이면 내림차순
            { it.eng },
            { -it.math },
            { it.name }
        )
    )

    students.forEach { println(it.name) }
}