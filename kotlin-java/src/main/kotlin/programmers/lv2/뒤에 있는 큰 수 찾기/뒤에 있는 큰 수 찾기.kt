package programmers.lv2.`뒤에 있는 큰 수 찾기`

import java.util.*

class Solution {
    fun solution(numbers: IntArray): IntArray {
        val stack = Stack<Int>()
        val answer = IntArray(numbers.size) { -1 }

        for (i in numbers.size - 1 downTo 0) {
            while (stack.isNotEmpty() && stack.peek() <= numbers[i]) {
                stack.pop()
            }

            if (stack.isNotEmpty()) {
                answer[i] = stack.peek()
            }
            stack.push(numbers[i])
        }

        return answer
    }
}