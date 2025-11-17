package goormlevel.lv2.`Queue`

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n,m) = readLine().split(" ").map{it.toInt()}
    val q = LinkedList<Int>() as Queue<Int>
    val sb = StringBuilder()

    repeat(n) {
        val st = StringTokenizer(readLine())
        when(st.nextToken()) {
            "push" -> {
                if(q.size == m) {
                    sb.append("Overflow\n")
                } else {
                    q.offer(st.nextToken().toInt())
                }
            }

            "pop" -> {
                if(q.isEmpty()) {
                    sb.append("Underflow\n");
                } else {
                    sb.append(q.poll()).append("\n");
                }
            }
        }
    }
    print(sb)
}