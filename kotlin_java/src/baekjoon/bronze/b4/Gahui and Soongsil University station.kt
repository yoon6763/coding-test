package baekjoon.bronze.b4

fun main() {
    var ans = 0
    repeat(4) {
        val (path, height) = readln().split(" ").let { it[0] to it[1].toInt() }
        ans += height * if (path == "Stair") 17 else 21
    }
    println(ans)
}
