package baekjoon.silver.s4

fun main() {
    while (true) {
        val line = readLine()!!
        if (line == ".")
            break

        val stack = ArrayList<Char>()

        for (i in line) {
            when (i) {
                '(', ')', '[', ']' -> {
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
            }
        }

        if(stack.isEmpty()) {
            println("yes")
        } else {
            println("no")
        }
    }
}