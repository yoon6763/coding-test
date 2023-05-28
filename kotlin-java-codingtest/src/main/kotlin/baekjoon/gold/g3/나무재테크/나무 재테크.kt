package baekjoon.gold.g3.나무재테크

import java.util.StringTokenizer

data class Tree(val x: Int, val y: Int, var age: Int, var isDeath: Boolean = false)

lateinit var trees: MutableList<Tree>
lateinit var map: Array<Array<Int>>
lateinit var add: Array<Array<Int>>
val dx = arrayOf(0, 0, 1, -1, 1, -1, 1, -1)
val dy = arrayOf(1, -1, 0, 0, -1, 1, 1, -1)
var n = 0

fun main() = with(System.`in`.bufferedReader()) {

    val nmk = readLine().split(" ").map { it.toInt() }
    n = nmk[0]
    val m = nmk[1]
    val k = nmk[2]

    // 모든 땅의 초기 양분은 5
    map = Array(n) { Array(n) { 5 } }

    // 1년당 추가되는 양분
    add = Array(n) {
        val st = StringTokenizer(readLine())
        Array(n) { st.nextToken().toInt() }
    }

    // 새 나무가 계속 추가될 예정이기 때문에 나이 순 내림차순 정렬
    trees = Array(m) {
        val st = StringTokenizer(readLine())
        Tree(st.nextToken().toInt() - 1, st.nextToken().toInt() - 1, st.nextToken().toInt())
    }.sortedByDescending { it.age }.toMutableList()

    // k년이 지난 후
    repeat(k) {
        spring()
        summer()
        autumn()
        winter()
    }

    println(trees.size)
}


fun spring() {
    // 새로운 1살짜리 나무가 계속 추가되기 때문에 역순으로 반복
    for (i in trees.size - 1 downTo 0) {
        if (map[trees[i].x][trees[i].y] - trees[i].age >= 0) {
            map[trees[i].x][trees[i].y] -= trees[i].age
            trees[i].age++
        } else {
            trees[i].isDeath = true
        }
    }
}

fun summer() {
    trees.forEach { tree ->
        if (tree.isDeath) map[tree.x][tree.y] += (tree.age / 2)
    }
    // 죽은 나무 제거
    trees.removeIf { it.isDeath }
}

fun autumn() {
    for (i in 0 until trees.size) {
        if (trees[i].age % 5 != 0)
            continue

        for (j in 0 until 8) {
            val nx = trees[i].x + dx[j]
            val ny = trees[i].y + dy[j]

            if (nx !in 0 until n || ny !in 0 until n) continue

            // 새 나무 추가
            trees.add(Tree(nx, ny, 1))
        }
    }
}

fun winter() {
    repeat(n) { x ->
        repeat(n) { y ->
            map[x][y] += add[x][y]
        }
    }
}