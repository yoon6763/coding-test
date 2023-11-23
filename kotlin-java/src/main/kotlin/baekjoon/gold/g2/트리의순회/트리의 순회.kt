package baekjoon.gold.g2.트리의순회

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

lateinit var inOrder: Array<Int>
lateinit var postOrder: Array<Int>
lateinit var position: Array<Int>
val sb = StringBuilder()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    inOrder = Array(n + 1) { 0 }
    postOrder = Array(n + 1) { 0 }
    position = Array(n + 1) { 0 }

    val inOrderInput = StringTokenizer(br.readLine())
    val postOrderInput = StringTokenizer(br.readLine())

    repeat(n) {
        inOrder[it] = inOrderInput.nextToken().toInt()
        postOrder[it] = postOrderInput.nextToken().toInt()
    }

    repeat(n) {
        position[inOrder[it]] = it
    }

    preOrder(0, n - 1, 0, n - 1)
    println(sb.toString())
}

fun preOrder(inStart: Int, inEnd: Int, postStart: Int, postEnd: Int) {
    if (inStart > inEnd || postStart > postEnd) return

    val root = postOrder[postEnd]
    sb.append(root).append(" ")

    val rootIdx = position[root]
    preOrder(inStart, rootIdx - 1, postStart, postStart + rootIdx - inStart - 1)
    preOrder(rootIdx + 1, inEnd, postStart + rootIdx - inStart, postEnd - 1)
}