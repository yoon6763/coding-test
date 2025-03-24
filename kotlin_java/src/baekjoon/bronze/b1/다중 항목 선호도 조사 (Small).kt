package baekjoon.bronze.b1

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val students = Array(n) { readln().split(" ") }
    repeat(m) {
        val keywords = readln().split(" ")
        var cnt = 0

        students.forEach { student ->
            var flag = true
            keywords.forEach { keyword ->
                if (keyword != "-" && keyword !in student) {
                    flag = false
                }
            }

            if(flag) cnt++
        }
        println(cnt)
    }
}