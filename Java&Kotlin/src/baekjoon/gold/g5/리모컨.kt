package baekjoon.gold.g5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.abs
import kotlin.math.min

lateinit var disableBtn: Array<String>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val target = br.readLine().toInt()
    val n = br.readLine().toInt()

    val usePlusAndMinus = abs(target - 100) // + - 버튼을 사용해서 이동할경우

    if (n == 0) {
        println(min(usePlusAndMinus, target.toString().length))
        return
    }

    val st = StringTokenizer(br.readLine(), " ")
    disableBtn = Array(n) { " " }
    for (i in 0 until n) disableBtn[i] = st.nextToken()

    var cnt = 0


    var upperBtn = target
    var lowerBtn = target


    while (true) {

        if (cnt + upperBtn.toString().length >= usePlusAndMinus && cnt + lowerBtn.toString().length >= usePlusAndMinus) {
            println(min(usePlusAndMinus, min(cnt + upperBtn.toString().length, cnt + lowerBtn.toString().length)))
            break
        }

        if (isAble(lowerBtn) && lowerBtn >= 0) {
            println(min(usePlusAndMinus, cnt + lowerBtn.toString().length))
            break
        }

        if (isAble(upperBtn)) {
            println(min(usePlusAndMinus, cnt + upperBtn.toString().length))
            break
        }

        upperBtn++
        lowerBtn--
        cnt++
    }
}

fun isAble(c: Int): Boolean {
    var channel = c.toString()

    for(i in channel) {
        if(i.toString() in disableBtn) {
            return false
        }
    }
    return true
}