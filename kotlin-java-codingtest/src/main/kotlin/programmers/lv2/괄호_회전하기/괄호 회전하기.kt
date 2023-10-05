package programmers.lv2.괄호_회전하기

import java.util.Stack

fun solution(s: String): Int {
    var ans = 0
    val sList = s.toMutableList()
    repeat(s.length) {
        sList.add(sList.removeAt(0))

        val stack = Stack<Char>()
        sList.forEach {
            if (stack.isEmpty()) stack.push(it)
            else {
                if (stack.peek() == '(' && it == ')' || stack.peek() == '[' && it == ']' || stack.peek() == '{' && it == '}') stack.pop()
                else stack.push(it)
            }
        }

        if (stack.isEmpty()) ans++
    }

    return ans
}