package baekjoon.gold.g5.`암호 만들기`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

val sb = StringBuilder()
lateinit var password: Array<String>
lateinit var isVowel: Array<Boolean>
var l = 0
var c = 0

fun main() {
    val vowel = arrayOf("a", "e", "i", "o", "u")

    val br = BufferedReader(InputStreamReader(System.`in`))
    val lc = br.readLine().split(" ")
    l = lc[0].toInt()
    c = lc[1].toInt()
    // c 개중 l 개

    val st = StringTokenizer(br.readLine())
    isVowel = Array(c) { false }
    password = Array(c) { "" }

    repeat(c) {
        password[it] = st.nextToken()
    }

    password.sort()

    repeat(c) {
        isVowel[it] = password[it] in vowel
    }

    backTracking(0, 0, "", 0, 0)
    print(sb)
}

fun backTracking(idx: Int, depth: Int, content: String, con: Int, vowel: Int) {
    if (depth == l) {
        // 최소 1개의 모음 (vowel, a e i o u)
        // 최소 2개의 자음 (con)
        if (vowel >= 1 && con >= 2) {
            sb.append(content).append("\n")
        }
        return
    }

    for (i in idx until c) {
        val nowVowel = isVowel[i]
        backTracking(
            i + 1,
            depth + 1,
            content + password[i],
            if (nowVowel) con else con + 1,
            if (nowVowel) vowel + 1 else vowel
        )
    }
}

/*
4 6
a t c i s w
 */


/*
acis
acit
aciw
acst
acsw
actw
aist
aisw
aitw
astw
cist
cisw
citw
istw
 */