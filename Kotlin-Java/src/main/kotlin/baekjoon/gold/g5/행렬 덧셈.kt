package baekjoon.gold.g5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nm = br.readLine().split(" ")
    val n = nm[0].toInt()
    val m = nm[1].toInt()

    val arr1 = Array(n) { Array(m) { 0 } }
    val arr2 = Array(n) { Array(m) { 0 } }

    repeat(n) { x ->
        val line = StringTokenizer(br.readLine(), " ")
        repeat(m) { y ->
            arr1[x][y] = line.nextToken().toInt()
        }
    }
    repeat(n) { x ->
        val line = StringTokenizer(br.readLine(), " ")
        repeat(m) { y ->
            arr2[x][y] = line.nextToken().toInt()
        }
    }

    repeat(n) { x ->
        repeat(m) { y ->
            print("${arr1[x][y] + arr2[x][y]} ")
        }
        println()
    }
}