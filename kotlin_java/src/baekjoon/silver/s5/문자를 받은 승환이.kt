package baekjoon.silver.s5

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)

    repeat(n) {
        val input = readLine().split(" ")
        val r = input[0].toInt()
        val c = input[1].toInt()
        val s = input[2]

        val arr = Array(r) { i -> CharArray(c) { j -> s[i * c + j] } }
        var bin = StringBuilder()

        var x = 0
        var y = 0
        var dir = 0
        val sb = StringBuilder()

        repeat(r * c) {
            bin.append(arr[x][y])
            arr[x][y] = '#'

            if (bin.length == 5) {
                val num = Integer.parseInt(bin.toString(), 2)
                if(num == 0) sb.append(' ')
                else sb.append((num + 64).toChar())

                bin = StringBuilder()
            }

            val nx = x + dx[dir]
            val ny = y + dy[dir]

            if (nx !in 0..<r || ny !in 0..<c || arr[nx][ny] == '#') {
                dir = (dir + 1) % 4
                x += dx[dir]
                y += dy[dir]
            } else {
                x = nx
                y = ny
            }
        }
        println(sb.trim())
    }
}