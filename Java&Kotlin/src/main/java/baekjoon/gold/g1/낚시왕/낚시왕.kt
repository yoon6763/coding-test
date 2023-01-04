package baekjoon.gold.g1.낚시왕

import java.util.StringTokenizer

enum class Direction {
    UP, DOWN, RIGHT, LEFT
}

data class Shark(var x: Int, var y: Int, val speed: Int, var d: Direction, val size: Int)

fun main(): Unit = with(System.`in`.bufferedReader()) {
    val (r, c, m) = readLine().split(" ").map { it.toInt() }

    val map = Array(r + 1) { Array(c + 1) { 0 } }

    val sharks = Array<Shark?>(m + 1) { null }

    for (i in 1..m) {
        val st = StringTokenizer(readLine())

        sharks[i] = Shark(
            st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt(), when (st.nextToken().toInt()) {
                1 -> Direction.UP
                2 -> Direction.DOWN
                3 -> Direction.RIGHT
                4 -> Direction.LEFT
                else -> Direction.LEFT
            }, st.nextToken().toInt()
        )

        map[sharks[i]!!.x][sharks[i]!!.y] = i
    }

    var cnt = 0

    // 열 개수만큼 반복
    for (i in 1..c) {

        // 상어 잡기
        for (j in 1..r) {
            if (map[j][i] != 0) {
                cnt += sharks[map[j][i]]?.size ?: 0
                sharks[map[j][i]] = null
                map[j][i] = 0
                break
            }
        }

        // 상어 이동
        for (k in 1 .. m) {
            if (sharks[k] != null) {
                val shark = sharks[k]!!
                map[shark.x][shark.y] = 0

                when (shark.d) {
                    Direction.UP -> {
                        var ny = shark.y + shark.speed
                        if ((ny / r) % 2 == 0) {
                            shark.d = Direction.UP
                        } else {
                            shark.d = Direction.DOWN
                        }
                        ny %= r

                        if (map[shark.x][ny] == 0) {
                            map[shark.x][ny] = k
                        } else {
                            if (sharks[map[shark.x][ny]]!!.size > shark.size) {
                                sharks[k] = null
                            } else {
                                sharks[map[shark.x][ny]] = null
                                map[shark.x][ny] = k
                            }
                        }
                    }
                    Direction.DOWN -> {
                        var ny = shark.y + shark.speed
                        if ((ny / r) % 2 == 0) {
                            shark.d = Direction.DOWN
                        } else {
                            shark.d = Direction.UP
                        }
                        ny %= r

                        if (map[shark.x][ny] == 0) {
                            map[shark.x][ny] = k
                        } else {
                            if (sharks[map[shark.x][ny]]!!.size > shark.size) {
                                sharks[k] = null
                            } else {
                                sharks[map[shark.x][ny]] = null
                                map[shark.x][ny] = k
                            }
                        }
                    }

                    Direction.LEFT -> {
                        var nx = shark.x + shark.speed
                        if ((nx / c) % 2 == 0) {
                            shark.d = Direction.LEFT
                        } else {
                            shark.d = Direction.RIGHT
                        }
                        nx %= c


                        if (map[nx][shark.y] == 0) {
                            map[nx][shark.y] = k
                        } else {
                            if (sharks[map[nx][shark.y]]!!.size > shark.size) {
                                sharks[k] = null
                            } else {
                                sharks[map[nx][shark.y]] = null
                                map[nx][shark.y] = k
                            }
                        }
                    }

                    Direction.RIGHT -> {
                        var nx = shark.x + shark.speed
                        if ((nx / c) % 2 == 0) {
                            shark.d = Direction.RIGHT
                        } else {
                            shark.d = Direction.LEFT
                        }
                        nx %= c

                        if (map[nx][shark.y] == 0) {
                            map[nx][shark.y] = k
                        } else {
                            if (sharks[map[nx][shark.y]]!!.size > shark.size) {
                                sharks[k] = null
                            } else {
                                sharks[map[nx][shark.y]] = null
                                map[nx][shark.y] = k
                            }
                        }
                    }
                }
            }
        }
    }

    println(cnt)
}