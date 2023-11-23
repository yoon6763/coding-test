package baekjoon

fun main() {
    while(true) {
        val n = readLine()!!
        if(n == "0") break

        val re = n.reversed().toInt()

        if(re == n.toInt()) {
            println("yes")
        } else {
            println("no")
        }
    }
}