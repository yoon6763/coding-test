fun main() {
    val solution = Solution2()
    print(solution.solution(intArrayOf(3, 30, 34, 5, 9)))
}

class Solution2 {
    fun solution(numbers: IntArray): String {
        var answer = ""

        var strArr = numbers.map { i -> (i.toString().toCharArray()[0]).toInt() * 3 }.sorted().reversed()

        strArr.forEach { i -> answer += i }


        return answer
    }
}