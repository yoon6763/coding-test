package baekjoon.gold.g1.낚시왕

import java.util.StringTokenizer

data class Shark(val idx: Int, val speed: Int, var direction: Int, val size: Int)

lateinit var map: Array<Array<ArrayList<Shark>>>
var r = 0
var c = 0

fun main(): Unit = with(System.`in`.bufferedReader()) {
    val rcm = readLine().split(" ").map { it.toInt() }
    r = rcm[0]
    c = rcm[1]
    val m = rcm[2]

    map = Array(r + 1) { Array(c + 1) { ArrayList() } }

    repeat(m) {
        val st = StringTokenizer(readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        val speed = st.nextToken().toInt()
        val direction = st.nextToken().toInt()
        val size = st.nextToken().toInt()

        map[x][y].add(Shark(it, speed, direction, size))
        eatShark(map)
    }

    var cnt = 0
    val direction = arrayOf(0, -1, 1, 1, -1)

    for (j in 1..c) {
        // 상어 잡기
        for (i in 1..r) {
            if (map[i][j].isNotEmpty()) {
                cnt += map[i][j][0].size
                map[i][j].removeAt(0)
                break
            }
        }

        val copyMap = Array(r + 1) { Array(c + 1) { ArrayList<Shark>() } }

        for (x in 1..r) {
            for (y in 1..c) {
                if (map[x][y].isNotEmpty()) {
                    val shark = map[x][y][0]

                    var nx = x
                    var ny = y

                    if (shark.direction == 1 || shark.direction == 2) {
                        // 상 하
                        if (x + shark.speed * direction[shark.direction] in 1..r) {
                            copyMap[x + shark.speed * direction[shark.direction]][y].add(shark)
                        } else {
                            val moveDistance = shark.speed % ((r - 1) * 2)

                            for (k in 0 until moveDistance) {
                                nx += direction[shark.direction]

                                if (nx == 0) {
                                    nx = 2
                                    shark.direction = 2
                                } else if (nx == r + 1) {
                                    nx = r - 1
                                    shark.direction = 1
                                }
                            }
                            copyMap[nx][ny].add(shark)
                        }
                    } else {
                        // 3 - 오른쪽 4 - 왼쪽
                        if (y + shark.speed * direction[shark.direction] in 1..c) {
                            copyMap[x][y + shark.speed * direction[shark.direction]].add(shark)
                        } else {
                            val moveDistance = shark.speed % ((c - 1) * 2)

                            for (k in 0 until moveDistance) {
                                ny += direction[shark.direction]

                                if (ny == 0) {
                                    ny = 2
                                    shark.direction = 3
                                } else if (ny == c + 1) {
                                    ny = c - 1
                                    shark.direction = 4
                                }
                            }
                            copyMap[nx][ny].add(shark)
                        }
                    }
                }
            }
        }
        eatShark(copyMap)

        for (x in 1..r) {
            for (y in 1..c) {
                if (map[x][y].isNotEmpty()) map[x][y].removeAt(0)
                if (copyMap[x][y].isNotEmpty()) map[x][y].add(copyMap[x][y][0])
            }
        }
    }

    println(cnt)
}

fun eatShark(map: Array<Array<ArrayList<Shark>>>) {
    for (i in 1..r) {
        for (j in 1..c) {
            if (map[i][j].size >= 2) {
                val maxSize = map[i][j].maxBy { it.size }

                var ptr = 0
                while (ptr < map[i][j].size) {
                    if (maxSize != map[i][j][ptr]) {
                        map[i][j].removeAt(ptr)
                    } else {
                        ptr++
                    }
                }
            }
        }
    }
}