package goormlevel.lv1.`딱지놀이`

import java.util.*

data class Node(var name: String, var star:Int, var circle:Int, var square:Int, var tri:Int)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()

    repeat(n) {
        var st = StringTokenizer(readLine())

        val a = Node("A", 0,0,0,0)
        repeat(st.nextToken().toInt()) {
            count(a,st.nextToken().toInt())
        }

        val b = Node("A", 0,0,0,0)
        st = StringTokenizer(readLine())
        repeat(st.nextToken().toInt()) {
            count(b,st.nextToken().toInt())
        }
        if(a == b) {
            sb.append("D").append("\n")
        } else {
            b.name = "B"
            sb.append(listOf(a,b).sortedWith(compareBy({-it.star}, {-it.circle}, {-it.square}, {-it.tri}))[0].name).append("\n")
        }
    }

    println(sb)
}

fun count(node:Node, num:Int) {
    when(num) {
        4 -> node.star++
        3 -> node.circle++
        2 -> node.square++
        1 -> node.tri++
    }
}