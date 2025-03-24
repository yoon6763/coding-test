package baekjoon.bronze.b2

fun main() {
    val n = readLine()!!.toInt()
    var solved = false
    for(i in 0 until n) {
        var result = i
        var temp = i
        while(temp > 0) {
            result += temp%10
            temp /= 10
        }

        if(result == n) {
            solved = true
            println(i)
            break
        }
    }

    if(!solved) {
        println(0)
    }

}