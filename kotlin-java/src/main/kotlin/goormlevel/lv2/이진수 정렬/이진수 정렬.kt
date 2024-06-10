package goormlevel.lv2.`이진수 정렬`

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map(String::toInt)
    println(readLine().split(" ").map(String::toInt).sortedWith(compareBy({ -it.toString(2).count { it == '1' } }, { -it }))[k - 1]
    )
}