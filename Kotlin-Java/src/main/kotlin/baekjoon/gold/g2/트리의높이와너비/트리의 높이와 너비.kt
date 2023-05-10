package baekjoon.gold.g2.트리의높이와너비

import java.util.StringTokenizer

data class Node(
    val n: Int, // 노드 번호
    var parent: Int = -1, // 부모 노드 번호
    var left: Int = -1, // 좌측 노드 번호
    var right: Int = -1, // 우측 노드 번호
    var colIdx: Int = -1, // 열 인덱스
    var depth: Int = -1 // 깊이(레벨)
)

lateinit var nodes: Array<Node>
var cnt = 1

fun main() = with(System.`in`.bufferedReader()) {

    val n = readLine().toInt()
    nodes = Array(n + 1) { Node(it) } // 0 번째 노드는 미사용

    repeat(n) {
        val st = StringTokenizer(readLine())
        val (parentNode, leftNode, rightNode) = Array(3) { st.nextToken().toInt() }

        if (rightNode != -1) {
            nodes[parentNode].right = rightNode // 현재 노드의 우측 노드 설정
            nodes[rightNode].parent = parentNode // 우측 노드의 부모 노드를 현재 노드로 설정
        }

        if (leftNode != -1) {
            nodes[parentNode].left = leftNode // 현재 노드의 좌측 노드 설정
            nodes[leftNode].parent = parentNode // 좌측 노드의 부모 노드를 현재 노드로 설정
        }
    }

    val root = nodes.indexOfLast { it.parent == -1 } // 부모가 없는 노드 찾기. 0번째 인덱스의 노드도 부모가 없으므로 맨 뒤 부터 찾음

    dfs(root, 1)

    var resultBinary = 0
    var resultLevel = 0

    // 1 레벨부터 최대 깊이 레벨까지 반복
    for (level in 1..nodes.maxOf { it.depth }) {

        val nowLevelNodes = nodes.filter { it.depth == level } // 현재 레벨의 노드만 필터링
        val binary = nowLevelNodes.maxOf { it.colIdx } - nowLevelNodes.minOf { it.colIdx } + 1 // 현재 레벨의 최대 열 번호 - 현재 레벨의 최소 열 번호

        if (resultBinary < binary) {
            resultBinary = binary
            resultLevel = level
        }
    }

    println("$resultLevel $resultBinary")
}

fun dfs(idx: Int, depth: Int) {
    if (idx == -1) return

    // 좌측 노드 - 현재 노드 - 우측 노드 순으로 탐색

    dfs(nodes[idx].left, depth + 1)

    nodes[idx].colIdx = cnt++ // 열 정보 저장
    nodes[idx].depth = depth // 깊이 정보 저장

    dfs(nodes[idx].right, depth + 1)
}