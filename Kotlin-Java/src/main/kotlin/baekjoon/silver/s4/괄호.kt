package baekjoon.silver.s4

fun main() {
    val n = readLine()!!.toInt()

    for (i in 0 until n) {
        val line = readLine()!!

        val stack = ArrayList<Char>()

        for (i in line) {
            stack.add(i)
            while (stack.size >= 2) {
                if ((stack[stack.size - 1] == ']' && stack[stack.size - 2] == '[') ||
                    ((stack[stack.size - 1] == ')' && stack[stack.size - 2] == '('))
                ) {
                    stack.removeLast()
                    stack.removeLast()
                } else {
                    break
                }
            }
        }

        if (stack.isEmpty()) {
            println("YES")
        } else {
            println("NO")
        }
    }
}