package baekjoon.silver.s4

import java.text.DecimalFormat

fun main() {
    val line = readLine()!!.split(" ")
    val payLine = readLine()!!.split(" ")
    val day = line[0].toInt()
    val workDay = line[1].toInt()
    val pay = Array<Double>(day) { 0.0 }

    for (i in 0 until day)
        pay[i] = payLine[i].toDouble()

    var queue = arrayListOf<Double>()


    for (i in 0 until workDay)
        queue.add(pay[i])
    var max = queue.sum()
    var tempValue = max

    for (i in workDay until day) {
        tempValue = tempValue - pay[i - workDay] + pay[i]
        if (tempValue > max)
            max = tempValue
    }

    val df = DecimalFormat("0")
    println(df.format(max))
}