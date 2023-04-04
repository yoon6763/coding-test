package baekjoon.gold.g4.감시

import java.util.*
import kotlin.math.min

data class CCTV(val type: Int, val x: Int, val y: Int)

val cctv = ArrayList<CCTV>()
var n = 0
var m = 0
lateinit var originMap: Array<Array<Int>>
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
        var sum = 0
        currentMap.forEach { sum += it.count { it == 0 } }

        min = min(min, sum)
        return
    }

    val cctvType = cctv[depth].type
    val maxDegree = when (cctvType) {
        1 -> 4
        2 -> 2
        3 -> 4
        4 -> 4
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
            5 -> cctvType5(cctv[depth], copiedMap, degree)
        }
        backTracking(depth + 1, copiedMap)
    }
}

fun cctvType1(point: CCTV, map: Array<Array<Int>>, degree: Int): Array<Array<Int>> {
    when (degree) {
        // 오른쪽
        0 -> {
            for (y in point.y until m) {
                if (map[point.x][y] == 6) break
                map[point.x][y] = -1
            }
        }

        // 아래
        1 -> {
            for (x in point.x until n) {
                if (map[x][point.y] == 6) break
                map[x][point.y] = -1
            }
        }

        // 왼쪽
        2 -> {
            for (y in point.y downTo 0) {
                if (map[point.x][y] == 6) break
                map[point.x][y] = -1
            }
        }

        // 위
        3 -> {
            for (x in point.x downTo 0) {
                if (map[x][point.y] == 6) break
                map[x][point.y] = -1
            }
        }
    }

    return map
}


fun cctvType2(point: CCTV, map: Array<Array<Int>>, degree: Int): Array<Array<Int>> {
    when (degree) {
        0 -> {
            for (y in point.y until m) {
                if (map[point.x][y] == 6) break
                map[point.x][y] = -1
            }
            for (y in point.y downTo 0) {
                if (map[point.x][y] == 6) break
                map[point.x][y] = -1
            }
        }

        1 -> {
            for (x in point.x until n) {
                if (map[x][point.y] == 6) break
                map[x][point.y] = -1
            }
            for (x in point.x downTo 0) {
                if (map[x][point.y] == 6) break
                map[x][point.y] = -1
            }
        }
    }

    return map
}

fun cctvType3(point: CCTV, map: Array<Array<Int>>, degree: Int): Array<Array<Int>> {
    when (degree) {
        // 위, 오른쪽
        0 -> {
            for (y in point.y until m) {
                if (map[point.x][y] == 6) break
                map[point.x][y] = -1
            }
            for (x in point.x downTo 0) {
                if (map[x][point.y] == 6) break
                map[x][point.y] = -1
            }
        }

        // 오른쪽, 아래
        1 -> {
            for (y in point.y until m) {
                if (map[point.x][y] == 6) break
                map[point.x][y] = -1
            }
            for (x in point.x until n) {
                if (map[x][point.y] == 6) break
                map[x][point.y] = -1
            }
        }

        // 아래, 왼쪽
        2 -> {
            for (x in point.x until n) {
                if (map[x][point.y] == 6) break
                map[x][point.y] = -1
            }
            for (y in point.y downTo 0) {
                if (map[point.x][y] == 6) break
                map[point.x][y] = -1
            }
        }

        // 왼쪽, 위
        3 -> {
            for (y in point.y downTo 0) {
                if (map[point.x][y] == 6) break
                map[point.x][y] = -1
            }
            for (x in point.x downTo 0) {
                if (map[x][point.y] == 6) break
                map[x][point.y] = -1
            }
        }
    }
    return map
}

fun cctvType4(point: CCTV, map: Array<Array<Int>>, degree: Int): Array<Array<Int>> {
    when (degree) {
        // 오른쪽, 위, 아래
        0 -> {
            for (y in point.y until m) {
                if (map[point.x][y] == 6) break
                map[point.x][y] = -1
            }
            for (x in point.x until n) {
                if (map[x][point.y] == 6) break
                map[x][point.y] = -1
            }
            for (x in point.x downTo 0) {
                if (map[x][point.y] == 6) break
                map[x][point.y] = -1
            }
        }

        // 왼쪽, 오른쪽, 아래
        1 -> {
            for (y in point.y until m) {
                if (map[point.x][y] == 6) break
                map[point.x][y] = -1
            }
            for (x in point.x until n) {
                if (map[x][point.y] == 6) break
                map[x][point.y] = -1
            }
            for (y in point.y downTo 0) {
                if (map[point.x][y] == 6) break
                map[point.x][y] = -1
            }
        }

        // 왼쪽, 위, 아래
        2 -> {
            for (x in point.x until n) {
                if (map[x][point.y] == 6) break
                map[x][point.y] = -1
            }
            for (y in point.y downTo 0) {
                if (map[point.x][y] == 6) break
                map[point.x][y] = -1
            }
            for (x in point.x downTo 0) {
                if (map[x][point.y] == 6) break
                map[x][point.y] = -1
            }
        }

        // 위, 왼쪽, 오른쪽
        3 -> {
            for (y in point.y until m) {
                if (map[point.x][y] == 6) break
                map[point.x][y] = -1
            }
            for (y in point.y downTo 0) {
                if (map[point.x][y] == 6) break
                map[point.x][y] = -1
            }
            for (x in point.x downTo 0) {
                if (map[x][point.y] == 6) break
                map[x][point.y] = -1
            }
        }
    }
    return map
}

fun cctvType5(point: CCTV, map: Array<Array<Int>>, degree: Int): Array<Array<Int>> {
    for (y in point.y until m) {
        if (map[point.x][y] == 6) break
        map[point.x][y] = -1
    }
    for (x in point.x until n) {
        if (map[x][point.y] == 6) break
        map[x][point.y] = -1
    }
    for (y in point.y downTo 0) {
        if (map[point.x][y] == 6) break
        map[point.x][y] = -1
    }
    for (x in point.x downTo 0) {
        if (map[x][point.y] == 6) break
        map[x][point.y] = -1
    }
    return map
}