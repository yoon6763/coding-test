package baekjoon.gold.g4.`스-스-스도쿠`

data class Node(val x: Int, val y: Int)

lateinit var board: Array<IntArray>
val emptyNode = ArrayList<Node>()
const val n = 9
var flag = false
val sb = StringBuilder()

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()

    repeat(t) {
        board = Array(n) { readLine().toCharArray().map { it - '0' }.toIntArray() }
        emptyNode.clear()
        flag = false

        for (i in 0..<n) {
            for (j in 0..<n) {
                if (board[i][j] == 0) emptyNode.add(Node(i, j))
            }
        }

        solve(0)

        if (!flag) {
            sb.append("Could not complete this grid.").append("\n")
        }

        if (it != t - 1) sb.append("\n")
    }

    print(sb)
}

fun solve(depth: Int) {
    if (!isValid()) return

    if (depth == emptyNode.size) {
        flag = true
        sb.append(board.joinToString("\n") { it.joinToString("") }).append("\n")
        return
    }

    for (i in 1..9) {
        board[emptyNode[depth].x][emptyNode[depth].y] = i
        solve(depth + 1)
        board[emptyNode[depth].x][emptyNode[depth].y] = 0
    }
}

fun isValid(): Boolean {
    for (i in 0..<n) {
        val rowVisited = BooleanArray(n + 1)
        val colVisited = BooleanArray(n + 1)

        for (j in 0..<n) {
            if (board[i][j] != 0 && rowVisited[board[i][j]]) return false
            rowVisited[board[i][j]] = true

            if (board[j][i] != 0 && colVisited[board[j][i]]) return false
            colVisited[board[j][i]] = true
        }
    }

    for (x in 0..<n step 3) {
        for (y in 0..<n step 3) {
            val squareVisited = BooleanArray(n + 1)

            for (dx in 0..<3) {
                for (dy in 0..<3) {
                    if (board[x + dx][y + dy] != 0 && squareVisited[board[x + dx][y + dy]]) return false
                    squareVisited[board[x + dx][y + dy]] = true
                }
            }
        }
    }

    return true
}