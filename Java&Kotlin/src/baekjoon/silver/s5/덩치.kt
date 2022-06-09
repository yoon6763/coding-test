package baekjoon.silver.s5

data class Body(val weight: Int, val height: Int, var degree: Int)

fun main() {
    val n = readLine()!!.toInt()
    val bodies = Array<Body?>(n) { null }

    for (i in 0 until n) {
        val line = readLine()!!.split(" ")
        bodies[i] = Body(line[0].toInt(), line[1].toInt(), -1)
    }

    for(i in 0 until n) {
        var degree = 1
        for(j in 0 until n) {
            if(bodies[i]!!.weight < bodies[j]!!.weight &&
                    bodies[i]!!.height < bodies[j]!!.height) {
                degree++
            }
        }
        bodies[i]!!.degree = degree
    }

    bodies.forEach { print("${it!!.degree} ") }
}