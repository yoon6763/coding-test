package baekjoon.s5

data class Node (val x: Int, val y:Int)

fun main() {
    val n = readLine()!!.toInt()

    val arr = Array<Node?>(n) { null }

    for(i in 0 until n) {
        val temp = readLine()!!.split(" ")
        arr[i] = Node(temp[0].toInt(), temp[1].toInt())
    }

    arr.sortWith(compareBy<Node?> { it!!.x }.thenBy {it!!.y})
    arr.forEach {
        println("${it!!.x} ${it!!.y}")
    }
}