package baekjoon.gold.g4.감시

import java.util.*
import kotlin.math.min

data class CCTV(val type: Int, val x: Int, val y: Int)

lateinit var originMap: Array<Array<Int>>
val cctv = ArrayList<CCTV>()
var n = 0
var m = 0
var min = Int.MAX_VALUE

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    originMap = Array(n) { x ->
        val st = StringTokenizer(readLine())
        Array(m) { y ->
            val value = st.nextToken().toInt()
            if (value in 1..5) cctv.add(CCTV(value, x, y))
            value
        }
    }

    backTracking(0, originMap)
    print(min)
}


fun backTracking(depth: Int, currentMap: Array<Array<Int>>) {
    if (depth == cctv.size) {
        val sum = currentMap.sumOf { it.count { it2 -> it2 == 0 } }
        min = min(min, sum)
        return
    }

    val cctvType = cctv[depth].type
    val maxDegree = when (cctvType) {
        1, 3, 4 -> 4
        2 -> 2
        5 -> 1
        else -> -1
    }

    for (degree in 0 until maxDegree) {
        val copiedMap = Array(n) { x -> Array(m) { y -> currentMap[x][y] } }

        when (cctvType) {
            1 -> cctvType1(cctv[depth], copiedMap, degree)
            2 -> cctvType2(cctv[depth], copiedMap, degree)
            3 -> cctvType3(cctv[depth], copiedMap, degree)
            4 -> cctvType4(cctv[depth], copiedMap, degree)
            5 -> cctvType5(cctv[depth], copiedMap)
        }
        backTracking(depth + 1, copiedMap)
    }
}

fun cctvType1(point: CCTV, map: Array<Array<Int>>, degree: Int) {
    when (degree) {
        // 오른쪽
        0 -> watchRight(point, map)
        // 아래
        1 -> watchDown(point, map)
        // 왼쪽
        2 -> watchLeft(point, map)
        // 위
        3 -> watchUp(point, map)
    }
}


fun cctvType2(point: CCTV, map: Array<Array<Int>>, degree: Int) {
    when (degree) {
        // 가로
        0 -> {
            watchRight(point, map)
            watchLeft(point, map)
        }

        // 세로
        1 -> {
            watchUp(point, map)
            watchDown(point, map)
        }
    }
}

fun cctvType3(point: CCTV, map: Array<Array<Int>>, degree: Int) {
    when (degree) {
        // 위, 오른쪽
        0 -> {
            watchRight(point, map)
            watchUp(point, map)
        }

        // 오른쪽, 아래
        1 -> {
            watchRight(point, map)
            watchDown(point, map)
        }

        // 아래, 왼쪽
        2 -> {
            watchDown(point, map)
            watchLeft(point, map)
        }

        // 왼쪽, 위
        3 -> {
            watchLeft(point, map)
            watchUp(point, map)
        }
    }
}

fun cctvType4(point: CCTV, map: Array<Array<Int>>, degree: Int) {
    when (degree) {
        // 오른쪽, 위, 아래
        0 -> {
            watchRight(point, map)
            watchUp(point, map)
            watchDown(point, map)
        }

        // 왼쪽, 오른쪽, 아래
        1 -> {
            watchLeft(point, map)
            watchRight(point, map)
            watchDown(point, map)
        }

        // 왼쪽, 위, 아래
        2 -> {
            watchLeft(point, map)
            watchUp(point, map)
            watchDown(point, map)
        }

        // 위, 왼쪽, 오른쪽
        3 -> {
            watchUp(point, map)
            watchLeft(point, map)
            watchRight(point, map)
        }
    }
}

fun cctvType5(point: CCTV, map: Array<Array<Int>>) {
    watchRight(point, map)
    watchLeft(point, map)
    watchUp(point, map)
    watchDown(point, map)
}

fun watchRight(p: CCTV, map: Array<Array<Int>>) {
    for (y in p.y until m) {
        if (map[p.x][y] == 6) break
        map[p.x][y] = -1
    }
}

fun watchLeft(p: CCTV, map: Array<Array<Int>>) {
    for (y in p.y downTo 0) {
        if (map[p.x][y] == 6) break
        map[p.x][y] = -1
    }
}

fun watchUp(p: CCTV, map: Array<Array<Int>>) {
    for (x in p.x downTo 0) {
        if (map[x][p.y] == 6) break
        map[x][p.y] = -1
    }
}

fun watchDown(p: CCTV, map: Array<Array<Int>>) {
    for (x in p.x until n) {
        if (map[x][p.y] == 6) break
        map[x][p.y] = -1
    }
}