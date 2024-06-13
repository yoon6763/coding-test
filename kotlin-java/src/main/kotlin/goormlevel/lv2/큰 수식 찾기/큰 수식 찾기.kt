package goormlevel.lv2.`큰 수식 찾기`

import java.util.*

val priority = hashMapOf(
    '+' to 2,
    '-' to 2,
    '*' to 1
)

val operation = hashMapOf(
    '+' to { a: Long, b: Long -> a + b },
    '-' to { a: Long, b: Long -> a - b },
    '*' to { a: Long, b: Long -> a * b },
)

fun main() {
    val (a, b) = readLine()!!.split(" ")
    println(maxOf(parse(a), parse(b)))
}

fun parse(str: String): Long {
    var sb = StringBuilder()
    var numList = ArrayList<Long>()
    var operList = ArrayList<Char>()

    str.forEach {
        if (it.isDigit()) {
            sb.append(it)
        } else {
            numList.add(sb.toString().toLong())
            operList.add(it)
            sb.clear()
        }
    }
    numList.add(sb.toString().toLong())


    val numStack = ArrayDeque<Long>()
    val operStack = ArrayDeque<Char>()

    numStack.add(numList[0])

    for (i in 0 until numList.size - 1) {
        while (operStack.isNotEmpty() && priority[operStack.last()]!! <= priority[operList[i]]!!) {
            val op = operStack.removeLast()
            val b = numStack.removeLast()
            val a = numStack.removeLast()
            numStack.add(operation[op]!!(a, b))
        }
        operStack.add(operList[i])
        numStack.add(numList[i + 1])
    }

    while (operStack.isNotEmpty()) {
        val op = operStack.removeLast()
        val b = numStack.removeLast()
        val a = numStack.removeLast()
        numStack.add(operation[op]!!(a, b))
    }

    return numStack.first()
}