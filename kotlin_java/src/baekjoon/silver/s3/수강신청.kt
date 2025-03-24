package baekjoon.silver.s3

fun main(){
    val hash = HashMap<String, Int>()
    val (n, m)=readln().split(" ").map {it.toInt()}
    repeat(m) {hash[readln()] = it}
    hash.toList().sortedBy {it.second}.subList(0, minOf(n,hash.size)).forEach {println(it.first)}
}