package baekjoon.gold.g4.거짓말

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

lateinit var parent: Array<Int>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nm = br.readLine().split(" ")
    val n = nm[0].toInt() // 사람의 수
    val m = nm[1].toInt() // 파티의 수

    parent = Array(n + 1) { it }

    val knowTruth = Array(n + 1) { false } // 진실을 아는 사람 - true 모르는 사람- false

    val stTruth = StringTokenizer(br.readLine(), " ")
    repeat(stTruth.nextToken().toInt()) { knowTruth[stTruth.nextToken().toInt()] = true }

    val party = Array(m) { ArrayList<Int>() }

    repeat(m) { i ->
        val stParty = StringTokenizer(br.readLine(), " ")
        val partyVisitNum = stParty.nextToken().toInt() // 파티에 참여한 사람 수

        for (j in 0 until partyVisitNum) {
            party[i].add(stParty.nextToken().toInt())

            if (j > 0) union(party[i][j], party[i][j - 1])
        }
    }

    val visited = Array(n + 1) { false }
    for (i in 1..n) {
        if (knowTruth[i] && !visited[i]) {
            val parent = find(i)

            // 부모가 같은지 비교
            for (j in 1..n) {
                if (parent == find(j)) {
                    knowTruth[j] = true
                    visited[j] = true
                }
            }
        }
    }

    val knowTruthArrayList = ArrayList<Int>()

    for (i in knowTruth.indices) {
        if (knowTruth[i]) knowTruthArrayList.add(i)
    }

    var partyCnt = m // 거짓말이 가능한 파티 카운트
    repeat(m) { i ->
        for(j in party[i].indices) {
            if(knowTruthArrayList.contains(party[i][j])) {
                partyCnt--
                break
            }
        }
    }

    println(partyCnt)
}


// union - find
fun union(x: Int, y: Int) {
    val nx = find(x)
    val ny = find(y)

    if (nx != ny) {
        parent[ny] = nx
    }
}

fun find(x: Int): Int {
    return if (x == parent[x]) x
    else {
        parent[x] = find(parent[x])
        parent[x]
    }
}