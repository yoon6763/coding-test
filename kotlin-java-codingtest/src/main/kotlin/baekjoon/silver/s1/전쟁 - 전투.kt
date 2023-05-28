package baekjoon

import kotlin.math.pow

var n = 0
var m = 0
var cnt = 0
lateinit var map: Array<Array<String>>

fun main() {
    val nm = readLine()!!.split(" ")
    var wPower = 0.0
    var bPower = 0.0

    n = nm[1].toInt()
    m = nm[0].toInt()

    map = Array(n) { Array<String>(m) { "" } }

    for (i in 0 until n) {
        val line = readLine()!!
        for (j in 0 until m) {
            map[i][j] = line[j].toString()
        }
    }

    for(i in 0 until n) {
        for(j in 0 until m) {
            cnt = 0
            wPower += dfs(i, j, "W").toDouble().pow(2)
            cnt = 0
            bPower += dfs(i,j,"B").toDouble().pow(2)
        }
    }

    print("${wPower.toInt()} ${bPower.toInt()}")
}

fun dfs(x:Int, y:Int, team:String):Int {
    if(x >= n || x < 0 || y < 0 || y >= m)
        return 0

    if(map[x][y] == team) {
        cnt++

        map[x][y] = ""

        dfs(x - 1, y, team)
        dfs(x + 1, y, team)
        dfs(x , y - 1, team)
        dfs(x, y + 1, team)

        return cnt
    }

    return 0
}