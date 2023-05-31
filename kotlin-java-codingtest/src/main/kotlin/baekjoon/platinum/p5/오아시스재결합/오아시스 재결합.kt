package baekjoon.platinum.p5.오아시스재결합

import java.util.*

data class Person(var height: Int, var cnt: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val stack = Stack<Person>()
    var cnt = 0L

    repeat(n) {
        val nowHeight = readLine().toInt()

        val person = Person(nowHeight, 1)

        while (stack.isNotEmpty() && stack.peek().height <= nowHeight) {
            val pop = stack.pop()
            cnt += pop.cnt
            if (pop.height == nowHeight) person.cnt += pop.cnt
        }

        if (stack.isNotEmpty()) cnt++

        stack.push(person)
    }

    println(cnt)
}