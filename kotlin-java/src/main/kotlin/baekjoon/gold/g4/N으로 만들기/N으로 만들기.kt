package baekjoon.gold.g4.`N으로 만들기`

var origin = ""
val set = mutableSetOf<String>()

fun main() = with(System.`in`.bufferedReader()) {
    origin = readLine()

    for (i in origin.indices) {
        dfs(i, i, origin[i].toString(), origin[i].toString())
    }

    println(set.size)
}

fun dfs(left: Int, right: Int, nowString: String, temp: String) {
    if (left == 0 && right == origin.length - 1) {
        set.add(temp)
        return
    }

    if (left - 1 >= 0) {
        dfs(left - 1, right, origin[left - 1] + nowString, temp + origin[left - 1] + nowString)
    }
    if (right + 1 < origin.length) {
        dfs(left, right + 1, nowString + origin[right + 1], temp + nowString + origin[right + 1])
    }
}