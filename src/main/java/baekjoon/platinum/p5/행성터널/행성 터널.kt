package baekjoon.platinum.p5.행성터널

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Arrays
import java.util.Collections
import java.util.StringTokenizer
import kotlin.math.abs

data class Node(var from: Int, var to: Int, var weight: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return this.weight - other.weight
    }
}

var total = 0
lateinit var parent: Array<Int>

data class Planet(var idx: Int, var x: Int, var y: Int, var z: Int)

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val planetArray = Array(n) { Planet(it, 0, 0, 0) }
    parent = Array(n) { it }

    val edgeList = ArrayList<Node>()

    repeat(n) { i ->
        val st = StringTokenizer(br.readLine(), " ")
        planetArray[i].x = st.nextToken().toInt()
        planetArray[i].y = st.nextToken().toInt()
        planetArray[i].z = st.nextToken().toInt()
    }

    Arrays.sort(planetArray, Comparator { o1, o2 ->
        o1.x - o2.x
    })

    repeat(n - 1) { i ->
        val weight = abs(planetArray[i].x - planetArray[i + 1].x)
        edgeList.add(Node(planetArray[i].idx, planetArray[i + 1].idx, weight))
    }
    Arrays.sort(planetArray, Comparator { o1, o2 ->
        o1.y - o2.y
    })

    repeat(n - 1) { i ->
        val weight = abs(planetArray[i].y - planetArray[i + 1].y)
        edgeList.add(Node(planetArray[i].idx, planetArray[i + 1].idx, weight))
    }
    Arrays.sort(planetArray, Comparator { o1, o2 ->
        o1.z - o2.z
    })

    repeat(n - 1) { i ->
        val weight = abs(planetArray[i].z - planetArray[i + 1].z)
        edgeList.add(Node(planetArray[i].idx, planetArray[i + 1].idx, weight))
    }

    edgeList.sortBy { it.weight }


    for (i in edgeList.indices) {
        val node = edgeList[i]

        if (find(node.from) != find(node.to)) {
            total += node.weight
            union(node.from, node.to)
        }
    }
    println(total)
    br.close()
}

fun find(x: Int): Int {
    return if (parent[x] == x) x
    else {
        parent[x] = find(parent[x])
        parent[x]
    }
}

fun union(x: Int, y: Int) {
    val nx = find(x)
    val ny = find(y)
    if (nx != ny) {
        if (x > y) {
            parent[ny] = nx
        } else {
            parent[nx] = ny
        }
    }
}

/*
5
11 -15 -15
14 -5 -15
-1 -1 -5
10 -4 -1
19 -4 19
 */