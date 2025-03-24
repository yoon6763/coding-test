package baekjoon.bronze.b5

fun main() {
    while (true) {
        val nm = readLine()!!.split(" ")
        if(nm[0].toInt() == 0 && nm[1].toInt() == 0) break

        if(nm[0].toInt() > nm[1].toInt()) println("Yes")
        else println("No")
    }
}