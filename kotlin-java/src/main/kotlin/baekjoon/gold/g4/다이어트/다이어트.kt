package baekjoon.gold.g4.`다이어트`

import java.util.ArrayList
import java.util.StringTokenizer

class Ingredient(val nutrient: IntArray, val price: Int)

lateinit var visited: BooleanArray
lateinit var ingredients: Array<Ingredient>
lateinit var target: IntArray

var answer = Int.MAX_VALUE
var elements = ArrayList<Int>()
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()

    var st = StringTokenizer(readLine())
    target = IntArray(4) { st.nextToken().toInt() }

    ingredients = Array(n) {
        st = StringTokenizer(readLine())
        Ingredient(IntArray(4) { st.nextToken().toInt() }, st.nextToken().toInt())
    }

    visited = BooleanArray(n)

    solve(0, IntArray(4), 0)

    if (answer == Int.MAX_VALUE) {
        println(-1)
        return
    }

    println("$answer\n${elements.joinToString(" ")}")
}

fun solve(idx: Int, cur: IntArray, price: Int) {
    if ((0..<4).all { cur[it] >= target[it] }) {
        if (price < answer) {
            answer = price
            elements.clear()
            elements.addAll((0..<n).filter { visited[it] }.map { it + 1 })
        }
        return
    }

    if (idx == n) return
    visited[idx] = true
    solve(
        idx + 1,
        cur.zip(ingredients[idx].nutrient) { a, b -> a + b }.toIntArray(),
        price + ingredients[idx].price
    )
    visited[idx] = false
    solve(idx + 1, cur, price)
}