package baekjoon.gold.g4.이진검색트리

import java.io.BufferedReader
import java.io.InputStreamReader

val sb = StringBuilder()

data class Node(val value: Int, var left: Node?, var right: Node?) {
    fun addChildNode(n: Int) {
        if (n > value) {
            // right가 비어있을 때 새 노드 삽입
            if (right == null) right = Node(n, null, null)
            // right가 있을 때 오른쪽 자식 노드로 가서 addChildNode 수행
            else right!!.addChildNode(n)
        } else {
            // left가 비어있을 때 새 노드 삽입
            if (left == null) left = Node(n, null, null)
            // left가 있을 때 왼쪽 자식 노드로 가서 addChildNode 수행
            else left!!.addChildNode(n)
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val root = Node(br.readLine().toInt(), null, null)

    while (true) {
        val input = br.readLine() ?: break // 입력값이 없을 때 break
        val n = input.toInt()
        root.addChildNode(n)
    }

    postOrder(root)
    println(sb)
}

fun postOrder(node: Node?) {
    if (node != null) {
        // post order (후위 순회) 시 왼쪽 -> 오른쪽 -> 루트
        postOrder(node.left)
        postOrder(node.right)
        sb.append(node.value).append("\n")
    }
}