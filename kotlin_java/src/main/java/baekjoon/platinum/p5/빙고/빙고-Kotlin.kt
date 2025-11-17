package baekjoon.platinum.p5.빙고

const val A = 1
const val B = 2
const val C = 3
const val D = 4
const val E = 5

val bingo = Array(6) { BooleanArray(6) }
var answerCount = 0

fun main() {
    solve(0)
    println(answerCount)
}

fun solve(idx: Int) {

    if (idx == 25) {
        if (!a1()) return
        if (!a2()) return
        if (!a3()) return
        if (!a4()) return
        if (!a5()) return

        if (!b1()) return
        if (!b2()) return
        if (!b3()) return
        if (!b4()) return
        if (!b5()) return

        if (!c1()) return
        if (!c2()) return
        if (!c3()) return
        if (!c4()) return
        if (!c5()) return

        if (!d1()) return
        if (!d2()) return
        if (!d3()) return
        if (!d4()) return
        if (!d5()) return

        if (!e1()) return
        if (!e2()) return
        if (!e3()) return
        if (!e4()) return
        if (!e5()) return

        answerCount += 1

        for (i in 1..5) {
            for (j in 1..5) {
                print(if (bingo[j][i]) "#" else ".")
            }
            println()
        }
        println()
        return
    }

    val row = idx / 5 + 1
    val col = idx % 5 + 1

    bingo[row][col] = true
    solve(idx + 1)
    bingo[row][col] = false
    solve(idx + 1)
}

fun isBingoLine(row: Int, col: Int): Boolean {
    if ((row == 1 && col == 1 || row == 2 && col == 2 || row == 3 && col == 3 || row == 4 && col == 4 || row == 5 && col == 5)
        && isA1ToE5Exist()
    ) return true

    if ((row == 1 && col == 5 || row == 2 && col == 4 || row == 3 && col == 3 || row == 4 && col == 2 || row == 5 && col == 1) &&
        isA5ToE1Exist()
    ) return true


    if (bingo[row][1] && bingo[row][2] && bingo[row][3] && bingo[row][4] && bingo[row][5]) return true
    if (bingo[1][col] && bingo[2][col] && bingo[3][col] && bingo[4][col] && bingo[5][col]) return true

    return false
}

// A1 -> E5 대각선 유무 확인
fun isA1ToE5Exist(): Boolean {
    return bingo[A][1] && bingo[B][2] && bingo[C][3] && bingo[D][4] && bingo[E][5]
}

// A5 -> E1 대각선 유무 확인
fun isA5ToE1Exist(): Boolean {
    return bingo[A][5] && bingo[B][4] && bingo[C][3] && bingo[D][2] && bingo[E][1]
}


fun a1(): Boolean {
    // A5에서 E1로 가는 대각선 줄은 빙고 줄이 아니다
    val flag = !(isA5ToE1Exist())
    return flag == bingo[A][1]
}

fun a2(): Boolean {
    // A4는 색칠이 안 되어 있다
    val flag = !bingo[A][4]
    return flag == bingo[A][2]
}

fun a3(): Boolean {
    // 이 칸(A3)은 빙고줄의 일부이다

    val flag = isBingoLine(A, 3)
    return flag == bingo[A][3]
}

fun a4(): Boolean {
    // A2는 색칠이 안 되어 있다
    val flag = !bingo[A][2]
    return flag == bingo[A][4]
}

fun a5(): Boolean {
    // E5는 색칠 되어 있다
    val flag = bingo[E][5]
    return flag == bingo[A][5]
}

fun b1(): Boolean {
    // 이 칸은 빙고줄의 일부가 아니다
    val flag = !isBingoLine(B, 1)
    return flag == bingo[B][1]
}

fun b2(): Boolean {
    // 모든 방향의 빙고줄이 존재한다 (가로, 세로, 대각선)

    var vertical = false
    var horizontal = false
    var diagonal = false

    for (i in 1..5) {
        if (bingo[i][1] && bingo[i][2] && bingo[i][3] && bingo[i][4] && bingo[i][5]) {
            horizontal = true
            break
        }
    }

    for (i in 1..5) {
        if (bingo[1][i] && bingo[2][i] && bingo[3][i] && bingo[4][i] && bingo[5][i]) {
            vertical = true
            break
        }
    }

    if (isA1ToE5Exist() || isA5ToE1Exist()) diagonal = true

    val flag = vertical && horizontal && diagonal
    return flag == bingo[B][2]
}

fun b3(): Boolean {
    // 색칠되어 있으나 빙고줄의 일부가 아닌 칸은 5개 이상이다
    var count = 0

    for (i in 1..5) {
        for (j in 1..5) {
            if (bingo[i][j] && !isBingoLine(i, j)) count++
        }
    }

    val flag = count >= 5
    return flag == bingo[B][3]
}

fun b4(): Boolean {
    // 제 2행과 D열중 적어도 하나는 빙고 줄이다
    val flag =
        bingo[A][2] && bingo[B][2] && bingo[C][2] && bingo[D][2] && bingo[E][2] || bingo[D][1] && bingo[D][2] && bingo[D][3] && bingo[D][4] && bingo[D][5]
    return flag == bingo[B][4]
}

fun b5(): Boolean {
    // 이 문제의 정답은 한 개이다
    val flag = false
    return flag == bingo[B][5]
}

fun c1(): Boolean {
    // A1에서 E5로 가는 대각선 줄은 빙고 줄이다
    val flag = isA1ToE5Exist()
    return flag == bingo[C][1]
}

fun c2(): Boolean {
    // 이 문장은 참이다
    val flag = true
    return flag == bingo[C][2]
}

fun c3(): Boolean {
    // 이 칸은 색칠되지 않았거나 빙고 줄의 일부이다
    val flag = !bingo[C][3] || isBingoLine(C, 3)
    return flag == bingo[C][3]
}

fun c4(): Boolean {
    // C열에는 색칠된 칸이 3개 이하이다
    var count = 0
    for (i in 1..5) if (bingo[C][i]) count++
    val flag = count <= 3
    return flag == bingo[C][4]
}

fun c5(): Boolean {
    // 이 칸은 색칠되어 있다
    val flag = bingo[C][5]
    return flag == bingo[C][5]
}

fun d1(): Boolean {
    // D4는 색칠 되어 있다
    val flag = bingo[D][4]
    return flag == bingo[D][1]
}

fun d2(): Boolean {
    // 17개 이하의 칸이 색칠 되어 있다
    var count = 0

    for (i in 1..5) {
        for (j in 1..5) {
            if (bingo[i][j]) count++
        }
    }

    val flag = count <= 17
    return flag == bingo[D][2]
}

fun d3(): Boolean {
    // 세로 빙고줄은 2개 이상이다
    var count = 0

    if (bingo[A][1] && bingo[A][2] && bingo[A][3] && bingo[A][4] && bingo[A][5]) count++
    if (bingo[B][1] && bingo[B][2] && bingo[B][3] && bingo[B][4] && bingo[B][5]) count++
    if (bingo[C][1] && bingo[C][2] && bingo[C][3] && bingo[C][4] && bingo[C][5]) count++
    if (bingo[D][1] && bingo[D][2] && bingo[D][3] && bingo[D][4] && bingo[D][5]) count++
    if (bingo[E][1] && bingo[E][2] && bingo[E][3] && bingo[E][4] && bingo[E][5]) count++

    val flag = count >= 2
    return flag == bingo[D][3]
}

fun d4(): Boolean {
    // D1은 색칠되어 있다
    val flag = bingo[D][1]
    return flag == bingo[D][4]
}

fun d5(): Boolean {
    // 빙고 줄의 개수는 3개 이상이다
    var count = 0

    for (i in 1..5) {
        if (bingo[i][1] && bingo[i][2] && bingo[i][3] && bingo[i][4] && bingo[i][5]) count++
    }

    for (i in 1..5) {
        if (bingo[1][i] && bingo[2][i] && bingo[3][i] && bingo[4][i] && bingo[5][i]) count++
    }

    if (isA1ToE5Exist()) count++
    if (isA5ToE1Exist()) count++

    val flag = count >= 3
    return flag == bingo[D][5]
}

fun e1(): Boolean {
    // 이 칸은 빙고줄의 일부이다
    val flag = isBingoLine(E, 1)
    return flag == bingo[E][1]
}

fun e2(): Boolean {
    // 빙고 줄의 일부인 칸은 짝수 개이다
    var count = 0

    for (i in 1..5) {
        for (j in 1..5) {
            if (isBingoLine(i, j)) count++
        }
    }

    val flag = count % 2 == 0 && count > 0
    return flag == bingo[E][2]
}

fun e3(): Boolean {
    // 빙고 줄의 일부가 아닌 칸은 10개 이상이다
    var count = 0

    for (i in 1..5) {
        for (j in 1..5) {
            if (!isBingoLine(i, j)) count++
        }
    }

    val flag = count >= 10
    return flag == bingo[E][3]
}

fun e4(): Boolean {
    // 대각선 빙고 줄이 있다
    val flag = isA1ToE5Exist() || isA5ToE1Exist()
    return flag == bingo[E][4]
}

fun e5(): Boolean {
    // A5는 색칠되어 있다
    val flag = bingo[A][5]
    return flag == bingo[E][5]
}