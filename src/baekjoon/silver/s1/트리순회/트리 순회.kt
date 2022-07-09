package baekjoon.silver.s1.트리순회

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

data class Node(var left: Int, var right: Int)

val sb = StringBuilder()
var n = -1
lateinit var node: Array<Node>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()


    node = Array<Node>(n) { Node(-1, -1) }

    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine(), " ")
        val root = st.nextToken()[0] - 'A'
        val left = st.nextToken()[0] - 'A'
        val right = st.nextToken()[0] - 'A'

        if (left in 0..26) node[root].left = left
        if (right in 0..26) node[root].right = right
    }


    preorder(0)
    sb.append("\n")
    inorder(0)
    sb.append("\n")
    postorder(0)

    println(sb.toString())
}


// 전위 순회
fun preorder(idx: Int) {
    sb.append((idx + 'A'.code).toChar())
    if (node[idx].left != -1) {
        preorder(node[idx].left)
    }
    if (node[idx].right != -1) {
        preorder(node[idx].right)
    }
}

// 중위 순회
fun inorder(idx: Int) {
    if (node[idx].left != -1) {
        inorder(node[idx].left)
    }
    sb.append((idx + 'A'.code).toChar())
    if (node[idx].right != -1) {
        inorder(node[idx].right)
    }
}

//후위순회
fun postorder(idx: Int) {
    if (node[idx].left != -1) {
        postorder(node[idx].left)
    }
    if (node[idx].right != -1) {
        postorder(node[idx].right)
    }
    sb.append((idx + 'A'.code).toChar())
}