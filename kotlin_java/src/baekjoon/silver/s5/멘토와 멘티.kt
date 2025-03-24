package baekjoon.silver.s5

fun main()=List(readln().toInt()){readln().split(" ")}.sortedWith(compareBy<List<String>>{it[0]}.thenByDescending{it[1]}).forEach{println(it.joinToString(" "))}