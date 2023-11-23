import java.util.Stack

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val nums = readLine().toCharArray()

    val stack = Stack<Char>()
    var cnt = 0

    for (num in nums) {
        while (stack.isNotEmpty() && stack.peek() < num && cnt < m) {
            stack.pop()
            cnt++
        }
        stack.push(num)
    }

    while (cnt < m) {
        stack.pop()
        cnt++
    }

    println(stack.joinToString(""))
}
