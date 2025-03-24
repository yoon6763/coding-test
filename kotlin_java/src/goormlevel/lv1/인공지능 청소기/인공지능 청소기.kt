package goormlevel.lv1.`인공지능 청소기`

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    repeat(n) {
        val (x, y, time) = readLine().split(" ").map { Math.abs(it.toInt()) }
        if(x + y > time) {
            println("NO")
        } else if( x + y == time) {
            println("YES")
        } else {
            val distance = time - x - y
            if(distance % 2 == 0) {
                println("YES")
            } else {
                println("NO")
            }
        }
    }
}