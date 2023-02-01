package baekjoon.gold.g4

private lateinit var star: Array<Array<Char>>

fun main() {
    val n = readLine()!!.toInt()
    star = Array(n) { Array(n * 2) { ' ' } }

    star11(0, n - 1, n)
    val sb = StringBuilder()
    star.forEach {
        it.forEach {
            sb.append(it)
        }
        sb.append("\n")
    }
    println(sb)
}

private fun star11(x: Int, y: Int, size: Int) {
    if (size == 3) {
        star[x][y] = '*'
        star[x + 1][y - 1] = '*'
        star[x + 1][y + 1] = '*'

        for (i in -2..2) star[x + 2][y + i] = '*'

    } else {
        val nSize = size / 2
        star11(x, y, nSize)
        star11(x + nSize, y - nSize, nSize)
        star11(x + nSize, y + nSize, nSize)
    }
}