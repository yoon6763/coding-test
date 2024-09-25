package baekjoon.bronze.b2

fun main() {
    val visited = IntArray(10)
    readln().forEach { visited[it.digitToInt()]++ }

    var flag = true

    for (i in 0..<10) {
        if (i == 0 || i == 1 || i == 2 || i == 8) continue
        if (visited[i] > 0) {
            flag = false
            break
        }
    }

    if (!flag) {
        println(0)
        return
    }

    if (visited[0] == 0 || visited[1] == 0 || visited[2] == 0 || visited[8] == 0) {
        println(1)
        return
    }

    val sum = visited[0]

    if (visited[1] != sum || visited[2] != sum || visited[8] != sum) {
        println(2)
        return
    }

    println(8)
}
