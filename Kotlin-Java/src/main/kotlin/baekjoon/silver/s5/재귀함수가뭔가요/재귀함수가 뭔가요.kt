package baekjoon.silver.s5.재귀함수가뭔가요

val str = arrayOf(
    "\"재귀함수가 뭔가요?\"",
    "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
    "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
    "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"",
)

val sb = StringBuilder()
var n = 0

fun main() {
    sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n")
    n = readln().toInt()
    solve(0)
    print(sb)
}

fun solve(depth: Int) {
    if (depth == n) {
        printUnderScore(depth)
        sb.append("\"재귀함수가 뭔가요?\"").append("\n")

        printUnderScore(depth)
        sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append("\n")
    } else {
        for (i in str.indices) {
            printUnderScore(depth)
            sb.append(str[i]).append("\n")
        }

        solve(depth + 1)
    }

    printUnderScore(depth)
    sb.append("라고 답변하였지.").append("\n")
}


fun printUnderScore(n:Int) {
    repeat(n) {
        sb.append("____")
    }
}