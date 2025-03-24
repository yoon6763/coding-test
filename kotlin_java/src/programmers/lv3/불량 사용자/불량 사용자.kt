package programmers.lv3.`불량 사용자`

import java.util.*

class Solution {
    lateinit var connect: Array<ArrayList<Int>>
    lateinit var rightVisited: BooleanArray
    lateinit var leftVisited: BooleanArray
    var answer = HashSet<String>()
    var n = 0
    var m = 0

    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        n = user_id.size
        m = banned_id.size

        connect = Array(n) { ArrayList() }
        leftVisited = BooleanArray(n)
        rightVisited = BooleanArray(m)

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (match(user_id[i], banned_id[j])) {
                    connect[i].add(j)
                }
            }
        }

        dfs(0, 0)

        return answer.size
    }

    fun match(s1: String, s2: String): Boolean {
        if (s1.length != s2.length) return false
        for (i in 0 until s1.length) {
            if (s1[i] != s2[i] && s2[i] != '*') return false
        }
        return true
    }

    fun dfs(cur: Int, depth: Int) {
        if (depth == m) {
            val sb = StringBuilder()
            for (i in 0 until n) {
                if (leftVisited[i]) sb.append(i)
            }
            answer.add(sb.toString())
            return
        }

        if (cur == n) {
            return
        }

        connect[cur].forEach { next ->
            if (rightVisited[next]) return@forEach
            leftVisited[cur] = true
            rightVisited[next] = true
            dfs(cur + 1, depth + 1)
            leftVisited[cur] = false
            rightVisited[next] = false
        }

        dfs(cur + 1, depth)
    }
}