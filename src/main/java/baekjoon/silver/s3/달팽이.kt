package baekjoon.silver.s3

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val line = readLine()!!.toInt()
    val target = readLine()!!.toInt()

    var arr = Array<Array<Int>>(line) { Array<Int>(line) { 0 } }

    var cnt = line * line
    var flag = 0
    var cal = 0
    var row = 0
    var deep = 0
    var target1 = 0
    var target2 = 0

    while (cnt > 0) {
        when (flag) {
            0 -> {
                for (i in 0 until line - deep) {
                    if (cnt == target) {
                        target1 = row + 1
                        target2 = cal + 1
                    }
                    arr[row][cal] = cnt
                    cnt--
                    row++
                }
                row--
                cal++
                deep++
            }
            1 -> {
                for (i in 0 until line - deep) {
                    if (cnt == target) {
                        target1 = row + 1
                        target2 = cal + 1
                    }
                    arr[row][cal] = cnt
                    cnt--
                    cal++
                }
                cal--
                row--
            }
            2 -> {
                for (i in 0 until line - deep) {
                    if (cnt == target) {
                        target1 = row + 1
                        target2 = cal + 1
                    }
                    arr[row][cal] = cnt
                    cnt--
                    row--
                }
                row++
                cal--
                deep++
            }
            3 -> {
                for (i in 0 until line - deep) {
                    if (cnt == target) {
                        target1 = row + 1
                        target2 = cal + 1
                    }
                    arr[row][cal] = cnt
                    cnt--
                    cal--
                }
                cal++
                row++
            }
        }

        flag++
        if (flag > 3) {
            flag = 0
        }
    }
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    for (i in 0 until line) {
        for (j in 0 until line) {
            bw.write(arr[i][j].toString() + " ")
        }
        bw.write("\n")
    }

    bw.write(target1.toString() + " " + target2)
    bw.close()
}