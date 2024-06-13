package goormlevel.lv1.`숫자 제거 배열`

fun main() {
    val (n, k) = readLine()!!.split(" ")
    print(readLine()!!.split(" ").filter { k !in it }.size)
}