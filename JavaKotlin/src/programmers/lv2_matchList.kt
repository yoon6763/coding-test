package programmers

class Solution4 {
    fun solution(n: Int, a: Int, b: Int): Int {

        var a1 = a
        var b1 = b
        var cnt = 0

        do {
            a1 = a1 / 2 + a1 % 2
            b1 = b1 / 2 + b1 % 2
            cnt++
        } while (a1 != b1)

        return cnt
    }
}

fun main() {
    val solution = Solution4()
    print(solution.solution(8, 4, 7))
}