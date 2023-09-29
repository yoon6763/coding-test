package baekjoon.platinum.p5.큐빙

import java.util.*

lateinit var cube: Array<Array<Array<Char>>>
const val U = 0
const val D = 1
const val F = 2
const val B = 3
const val L = 4
const val R = 5

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    cube = Array(6) { Array(3) { Array(3) { ' ' } } }

    repeat(readLine().toInt()) {

        cube[0].forEach { it.fill('w') } // U
        cube[1].forEach { it.fill('y') } // D
        cube[2].forEach { it.fill('r') } // F
        cube[3].forEach { it.fill('o') } // B
        cube[4].forEach { it.fill('g') } // L
        cube[5].forEach { it.fill('b') } // R

        val cmdCount = readLine()
        val st = StringTokenizer(readLine())

        while (st.hasMoreTokens()) {
            val cmd = st.nextToken()
            rotateCube(cmd[0], cmd[1])
        }

        for (i in 0 until 3) {
            for (j in 0 until 3) {
                sb.append(cube[0][i][j])
            }
            sb.append("\n")
        }
    }

    print(sb)
}

fun rotateCube(dir: Char, rotateDir: Char) {
    val tempCube = Array(6) { i -> Array(3) { j -> Array(3) { k -> cube[i][j][k] } } }

    when (dir) {
        // 해당 면을 바라봤을 떄 시계방향
        'U' -> {
            if (rotateDir == '+') {
                for (i in 0 until 3) {
                    cube[F][0][i] = tempCube[R][0][i]
                    cube[R][0][i] = tempCube[B][0][i]
                    cube[B][0][i] = tempCube[L][0][i]
                    cube[L][0][i] = tempCube[F][0][i]
                }
            } else {
                for (i in 0 until 3) {
                    cube[F][0][i] = tempCube[L][0][i]
                    cube[L][0][i] = tempCube[B][0][i]
                    cube[B][0][i] = tempCube[R][0][i]
                    cube[R][0][i] = tempCube[F][0][i]
                }
            }
        }

        'D' -> {
            if (rotateDir == '+') {
                for (i in 0 until 3) {
                    cube[F][2][i] = tempCube[L][2][i]
                    cube[L][2][i] = tempCube[B][2][i]
                    cube[B][2][i] = tempCube[R][2][i]
                    cube[R][2][i] = tempCube[F][2][i]
                }
            } else {
                for (i in 0 until 3) {
                    cube[F][2][i] = tempCube[R][2][i]
                    cube[R][2][i] = tempCube[B][2][i]
                    cube[B][2][i] = tempCube[L][2][i]
                    cube[L][2][i] = tempCube[F][2][i]
                }
            }
        }

        'F' -> {
            if (rotateDir == '+') {
                for (i in 0 until 3) {
                    cube[U][2][i] = tempCube[L][2 - i][2]
                    cube[L][i][2] = tempCube[D][0][i]
                    cube[D][0][i] = tempCube[R][2 - i][0]
                    cube[R][i][0] = tempCube[U][2][i]
                }
            } else {
                for (i in 0 until 3) {
                    cube[U][2][i] = tempCube[R][i][0]
                    cube[R][i][0] = tempCube[D][0][2 - i]
                    cube[D][0][i] = tempCube[L][i][2]
                    cube[L][i][2] = tempCube[U][2][2 - i]
                }
            }
        }

        'B' -> {
            if (rotateDir == '+') {
                for (i in 0 until 3) {
                    cube[U][0][i] = tempCube[R][i][2]
                    cube[R][i][2] = tempCube[D][2][2 - i]
                    cube[D][2][i] = tempCube[L][i][0]
                    cube[L][i][0] = tempCube[U][0][2 - i]
                }
            } else {
                for (i in 0 until 3) {
                    cube[U][0][i] = tempCube[L][2 - i][0]
                    cube[L][i][0] = tempCube[D][2][i]
                    cube[D][2][i] = tempCube[R][2 - i][2]
                    cube[R][i][2] = tempCube[U][0][i]
                }
            }
        }

        'L' -> {
            if (rotateDir == '+') {
                for (i in 0 until 3) {
                    cube[U][i][0] = tempCube[B][2 - i][2]
                    cube[B][i][2] = tempCube[D][2 - i][0]
                    cube[D][i][0] = tempCube[F][i][0]
                    cube[F][i][0] = tempCube[U][i][0]
                }
            } else {
                for (i in 0 until 3) {
                    cube[U][i][0] = tempCube[F][i][0]
                    cube[F][i][0] = tempCube[D][i][0]
                    cube[D][i][0] = tempCube[B][2 - i][2]
                    cube[B][i][2] = tempCube[U][2 - i][0]
                }
            }
        }

        'R' -> {
            if (rotateDir == '+') {
                for (i in 0 until 3) {
                    cube[U][i][2] = tempCube[F][i][2]
                    cube[F][i][2] = tempCube[D][i][2]
                    cube[D][i][2] = tempCube[B][2 - i][0]
                    cube[B][i][0] = tempCube[U][2 - i][2]
                }
            } else {
                for (i in 0 until 3) {
                    cube[U][i][2] = tempCube[B][2 - i][0]
                    cube[B][i][0] = tempCube[D][2 - i][2]
                    cube[D][i][2] = tempCube[F][i][2]
                    cube[F][i][2] = tempCube[U][i][2]
                }
            }
        }
    }

    rotateSide(dir, rotateDir)

//    val floor = arrayOf('U', 'D', 'F', 'B', 'L', 'R')
//
//    println("$dir$rotateDir")
//    for (i in 0 until 6) {
//        println(floor[i] + "면")
//        for (j in 0 until 3) {
//            for (k in 0 until 3) {
//                print("${cube[i][j][k]} ")
//            }
//            println()
//        }
//        println()
//    }
//    println()
}

// 면 시계/반시계 회전
fun rotateSide(dir: Char, rotateDir: Char) {
    val tempCube = Array(6) { i -> Array(3) { j -> Array(3) { k -> cube[i][j][k] } } }
    val dirNum = when (dir) {
        'U' -> U
        'D' -> D
        'F' -> F
        'B' -> B
        'L' -> L
        else -> R
    }

    if (rotateDir == '+') {
        // 시계방향 회전
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                cube[dirNum][i][j] = tempCube[dirNum][2 - j][i]
            }
        }
    } else {
        // 반시계방향 회전
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                cube[dirNum][i][j] = tempCube[dirNum][j][2 - i]
            }
        }
    }
}