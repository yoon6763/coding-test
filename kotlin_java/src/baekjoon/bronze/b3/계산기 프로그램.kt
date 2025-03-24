package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    var n = readLine().toInt()
    while (true) {
        val oper = readLine()
        if(oper == "=") {
            println(n)
            break
        }
        val num = readLine().toInt()
        when(oper) {
            "+" -> n += num
            "-" -> n -= num
            "*" -> n *= num
            "/" -> n /= num
        }
    }
}