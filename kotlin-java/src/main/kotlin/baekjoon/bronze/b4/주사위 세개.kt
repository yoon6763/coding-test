package baekjoon.bronze.b4

fun main() {
    val n = readLine()!!.split(" ").map { it.toInt() }

    if(n[0] == n[1] && n[1]== n[2]) {
        println(10000 + n[0] * 1000)
    } else if(n[0] != n[1] && n[1] != n[2] && n[0] != n[2]) {
        println(n.maxOrNull()!! * 100)
    } else {
        var x = 0
        x = if(n[0] == n[1] || n[0] == n[2]) {
            n[0]
        } else {
            n[1]
        }
        println(x * 100 + 1000)
    }
}