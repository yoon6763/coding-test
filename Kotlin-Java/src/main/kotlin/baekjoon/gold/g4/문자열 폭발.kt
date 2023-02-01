package baekjoon.gold.g4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val line = br.readLine()
    val boom = br.readLine()

    val boomLen = boom.length

    val stack = Stack<Char>()

    for (ch in line) {
        stack.add(ch)

        // 스택의 길이가 boom의 길이보다 클 때만
        if (stack.size >= boomLen) {
            var isEqual = true

            // 스택의 마지막 boomLen 만큼의 크기의 문자열과 boom 문자열 비교
            for (i in 0 until boomLen) {
                if (stack[stack.size - boomLen + i] != boom[i]) {
                    isEqual = false
                    break
                }
            }

            if(isEqual) {
                repeat(boomLen) {
                    stack.pop()
                }
            }
        }
    }
    val sb = StringBuilder()

    if (stack.isEmpty()) print("FRULA")
    else {
        stack.forEach { sb.append(it) }
        println(sb.toString())
    }
}

/*
mirkovC4nizCC44
C4
 */