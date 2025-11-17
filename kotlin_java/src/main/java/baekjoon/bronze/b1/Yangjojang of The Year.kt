package baekjoon.bronze.b1

data class Univ(val name: String, val n: Int)

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val list = ArrayList<Univ>()

        repeat(readLine().toInt()) {
            val line = readLine().split(" ")
            list.add(Univ(line[0], line[1].toInt()))
        }

        list.sortByDescending { it.n }
        println(list[0].name)
    }
}