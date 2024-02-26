package baekjoon.silver.s5.`점수 계산`

data class Score(val idx: Int, val score: Int)
fun main()=Array(8){Score(it + 1,readln().toInt())}.sortedByDescending{it.score}.slice(0 until 5).let {
    println(it.sumOf{it.score})
    println(it.map{it.idx}.sorted().joinToString(" "))
}
