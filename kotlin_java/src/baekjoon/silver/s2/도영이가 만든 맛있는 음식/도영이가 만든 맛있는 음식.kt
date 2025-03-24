package baekjoon.silver.s2.`도영이가 만든 맛있는 음식`

import kotlin.math.abs

data class Ingredient(val sour: Int, val bitter: Int)

lateinit var ingredients: Array<Ingredient>

var answer = Int.MAX_VALUE
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    ingredients = Array(n) {
        val (sour, bitter) = readLine().split(" ").map { it.toInt() }
        Ingredient(sour, bitter)
    }

    solve(0, 1, 0, false)

    println(answer)
}

fun solve(index: Int, sour: Int, bitter: Int, isIncludeIngredient: Boolean) {
    if (index == n) {
        if (!isIncludeIngredient) return
        answer = minOf(answer, abs(sour - bitter))
        return
    }

    solve(index + 1, sour, bitter, isIncludeIngredient)
    solve(index + 1, sour * ingredients[index].sour, bitter + ingredients[index].bitter, true)
}