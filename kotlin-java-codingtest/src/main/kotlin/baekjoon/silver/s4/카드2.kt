package baekjoon.silver.s4

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val num = readLine()!!.toInt()

    var arraylist = LinkedList<Int>()
    var flag = true

    for (i in 0 until num) {
        arraylist.add(i + 1)
    }

    while (arraylist.size > 1) {
        if(flag) {
            arraylist.removeAt(0)
        } else {
            val temp = arraylist[0]
            arraylist.removeAt(0)
            arraylist.add(temp)
        }
        flag = !flag
    }

    print(arraylist[0])
}