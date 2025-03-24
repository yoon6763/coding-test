package goormlevel.lv2.`M배 배열`

fun main() {
    val (n, m) = readLine()!!.split(" ").map{it.toInt()}
    println(readLine()!!.split(" ").map{it.toInt()}.map{if(it % m == 0) it else it * m}.joinToString(" "))
}