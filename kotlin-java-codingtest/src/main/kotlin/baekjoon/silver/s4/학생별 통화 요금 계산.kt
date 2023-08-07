package baekjoon.silver.s4

import kotlin.math.ceil

fun main() = with(System.`in`.bufferedReader()) {
    val hashMap = HashMap<String, Int>()
    repeat(readLine().toInt()) {
        val (time, name) = readLine().split(" ")
        val (hour, minute) = time.split(":").map { it.toInt() }
        hashMap[name] = hashMap.getOrDefault(name, 0) + hour * 60 + minute
    }
    val sb = StringBuilder()

    val students = ArrayList<Pair<String, Int>>()
    hashMap.forEach { (name, time) ->
        val fee = if(time <= 100) {
            10
        } else {
            10 + ceil((time - 100) / 50.0).toInt() * 3
        }
        students.add(Pair(name, fee))
    }
    students.sortWith(compareBy({ -it.second }, { it.first }))
    students.forEach { (name, fee) ->
        sb.append("$name $fee\n")
    }

    print(sb)
}