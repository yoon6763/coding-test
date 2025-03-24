package baekjoon.silver.s4

import java.util.LinkedList
import java.util.Queue

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val queue = LinkedList<Int>() as Queue<Int>

    val sb = StringBuilder()

    repeat(n) {
        val cmd = readLine()

        when {
            cmd.startsWith("push") -> queue.offer(cmd.split(" ")[1].toInt())
            cmd == "empty" -> sb.append(if (queue.isEmpty()) 1 else 0).append("\n")
            cmd == "size" -> sb.append(queue.size).append("\n")
            cmd == "front" -> sb.append(if(queue.isEmpty()) -1 else queue.first()).append("\n")
            cmd == "back" -> sb.append(if(queue.isEmpty()) -1 else queue.last()).append("\n")
            cmd == "pop" -> sb.append(if(queue.isEmpty()) -1 else queue.poll()).append("\n")
        }
    }

    print(sb)
}