package baekjoon.silver.s4

import java.util.*

fun main() {
    val list: LinkedList<Int> = LinkedList()

    val n = readLine()!!.toInt()

    repeat(n) {
        when(val line = readLine()!!) {

            "pop_front" -> {
                if(list.size == 0) println(-1) else println(list.removeFirst())
            }
            "pop_back" -> {
                if(list.size == 0) println(-1) else println(list.removeLast())
            }
            "size" -> {
                println(list.size)
            }
            "empty" -> {
                println(if(list.size == 0) 1 else 0)
            }
            "front" -> {
                if(list.size == 0) println(-1) else println(list.first)
            }
            "back" -> {
                if(list.size == 0) println(-1) else println(list.last)
            }
            else -> {
                if(line.startsWith("push_front")) {
                    list.addFirst(line.split(" ")[1].toInt())
                } else {
                    list.addLast(line.split(" ")[1].toInt())
                }
            }
        }
    }
}

/*
    push_front X: 정수 X를 덱의 앞에 넣는다.
    push_back X: 정수 X를 덱의 뒤에 넣는다.
    pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    size: 덱에 들어있는 정수의 개수를 출력한다.
    empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
    front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */