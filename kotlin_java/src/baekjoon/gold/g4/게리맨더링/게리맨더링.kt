package baekjoon.gold.g4.게리맨더링

import java.util.StringTokenizer
import kotlin.math.abs

lateinit var district: List<Int>
lateinit var connect: Array<MutableList<Int>>
lateinit var selected: Array<Boolean>
lateinit var visited: Array<Boolean>
var answer = Int.MAX_VALUE
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    district = readLine().split(" ").map { it.toInt() }
    connect = Array(n) { ArrayList() }
    selected = Array(n) { false }
    visited = Array(n) { false }

    for (i in 0 until n) {
        val st = StringTokenizer(readLine())
        repeat(st.nextToken().toInt()) {
            connect[i].add(st.nextToken().toInt() - 1)
        }
    }

    selectDistrict(0, 0)

    println(if (answer == Int.MAX_VALUE) -1 else answer)
}

fun selectDistrict(index: Int, depth: Int) {
    if (depth == n) {
        if (selected.all { it } || selected.none { it }) return // 두 선거구로 나눌 수 없는 경우 (모두 true 파티 or 모두 false 파티)

        visited.fill(false)

        makeParty(true) // true 선거구 연결
        makeParty(false) // false 선거구 연결

        if (visited.any { !it }) return // 연결되지 않은 구역이 있는 다음 케이스로

        val party1 = district.filterIndexed { index, _ -> selected[index] }.sum() // 선거구1 인구 수
        val party2 = district.filterIndexed { index, _ -> !selected[index] }.sum() // 선거구2 인구 수

        answer = minOf(answer, abs(party1 - party2))
        return
    }

    for (i in index until n) {
        selected[i] = true
        selectDistrict(i + 1, depth + 1)
        selected[i] = false
        selectDistrict(i + 1, depth + 1)
    }
}

fun makeParty(party: Boolean) {
    val q = ArrayDeque<Int>()

    for (i in 0 until n) {
        if (selected[i] == party) {
            q.add(i)
            visited[i] = true
            break
        }
    }

    while (q.isNotEmpty()) {
        val cur = q.removeFirst()

        connect[cur].forEach { next ->
            if (visited[next] || selected[next] != party) return@forEach
            visited[next] = true
            q.add(next)
        }
    }
}