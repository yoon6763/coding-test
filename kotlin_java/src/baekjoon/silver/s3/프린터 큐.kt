package baekjoon.silver.s3

import java.util.LinkedList
import java.util.StringTokenizer

data class Docu(var idx: Int, var priority: Int)

fun main() {
    val testCase = readLine()!!.toInt()

    repeat(testCase) {
        val nm = readLine()!!.split(" ")
        val n = nm[0].toInt()
        val target = nm[1].toInt()

        val docuList = LinkedList<Docu>()
        val priorities = StringTokenizer(readLine()!!, " ")

        repeat(n) {
            docuList.offer(Docu(it, priorities.nextToken().toInt()))
        }
        var cnt = 0
        while (docuList.isNotEmpty()) {
            val maxValue = docuList.maxOf { it.priority }
            var isFound = false

            for (i in docuList.indices) {
                if (docuList.peek().priority != maxValue) {
                    docuList.offer(docuList.poll())
                } else {
                    val temp = docuList.poll()
                    cnt++

                    if(temp.idx == target) {
                        println(cnt)
                        isFound = true
                    }
                    break
                }
            }

            if(isFound) break
        }
    }
}