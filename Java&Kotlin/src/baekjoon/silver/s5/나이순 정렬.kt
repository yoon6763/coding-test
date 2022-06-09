package baekjoon.silver.s5

data class Person(val age: Int, val name: String)

fun main() {
    val n = readLine()!!.toInt()
    val arr = Array<Person?>(n){null}

    for(i in 0 until n) {
        val line = readLine()!!.split(" ")
        arr[i] = Person(line[0].toInt(), line[1])
    }

    arr.sortBy { it!!.age }
    arr.forEach { println("${it!!.age} ${it!!.name}") }
}