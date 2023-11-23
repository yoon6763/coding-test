package baekjoon.gold.g5

import java.util.LinkedList
import kotlin.math.pow

fun main() {
    val gear = Array(4) { LinkedList<Char>() }

    // 12시 방향부터 시계 방향으로 주어짐
    // 오른쪽은 idx = 2, 왼쪽은 idx = 6
    for (i in 0 until 4) {
        readLine()!!.forEach {
            gear[i].add(it)
        }
    }

    val n = readLine()!!.toInt()

    for (i in 0 until n) {
        val input = readLine()!!.split(" ")
        val gearIdx = input[0].toInt() - 1
        val direction = input[1].toInt() // 1 : 시계방향, -1 : 반시계방향

        val isRotate = arrayOf(false, false, false, false)
        val flags = arrayOf(0, 0, 0, 0)
        flags[gearIdx] = direction
        isRotate[gearIdx] = true


        for (j in gearIdx until 3) {
            if (gear[j][2] != gear[j + 1][6]) {
                isRotate[j + 1] = true
                flags[j + 1] = flags[j] * -1
            } else {
                break
            }
        }

        for (j in gearIdx downTo 1) {
            if (gear[j][6] != gear[j - 1][2]) {
                isRotate[j - 1] = true
                flags[j - 1] = flags[j] * -1
            } else {
                break
            }
        }

        for (j in 0 until 4) {
            if (isRotate[j]) {
                when (flags[j]) {
                    1 -> {
                        gear[j].addFirst(gear[j].removeLast())
                    }

                    -1 -> {
                        gear[j].addLast(gear[j].removeFirst())
                    }
                }
            }
        }
    }

    /*
        N = 0, S = 1
        1번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 1점
        2번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 2점
        3번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 4점
        4번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 8점
     */

    var score = 0

    for (i in 0 until 4) {
        if (gear[i][0] == '1') score += (2.0.pow(i)).toInt()
    }

    println(score)
}