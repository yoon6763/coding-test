package baekjoon.gold.g1.`하이퍼 토마토`

import java.util.StringTokenizer

data class Tomato(
    val dimension0: Int,
    val dimension1: Int,
    val dimension2: Int,
    val dimension3: Int,
    val dimension4: Int,
    val dimension5: Int,
    val dimension6: Int,
    val dimension7: Int,
    val dimension8: Int,
    val dimension9: Int,
    val dimension10: Int,
)

val directions = arrayOf(
    arrayOf(1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
    arrayOf(0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
    arrayOf(0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
    arrayOf(0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
    arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
    arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
    arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0),
    arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0),
    arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0),
    arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0),
    arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1)
)


fun main() = with(System.`in`.bufferedReader()) {
    val sizes = StringTokenizer(readLine())
    val M = sizes.nextToken().toInt()
    val N = sizes.nextToken().toInt()
    val O = sizes.nextToken().toInt()
    val P = sizes.nextToken().toInt()
    val Q = sizes.nextToken().toInt()
    val R = sizes.nextToken().toInt()
    val S = sizes.nextToken().toInt()
    val T = sizes.nextToken().toInt()
    val U = sizes.nextToken().toInt()
    val V = sizes.nextToken().toInt()
    val W = sizes.nextToken().toInt()

    val map = Array(M) { Array(N) { Array(O) { Array(P) { Array(Q) { Array(R) { Array(S) { Array(T) { Array(U) { Array(V) { Array(W) { 0 } } } } } } } } } } }

    val queue = ArrayDeque<Tomato>()
    var restTomatoCount = 0

    for(w in 0 until W)
        for(v in 0 until V)
            for(u in 0 until U)
                for(t in 0 until T)
                    for(s in 0 until S)
                        for(r in 0 until R)
                            for(q in 0 until Q)
                                for(p in 0 until P)
                                    for(o in 0 until O)
                                        for(n in 0 until N) {
                                            val st = StringTokenizer(readLine())

                                            for(m in 0 until M) {
                                                map[m][n][o][p][q][r][s][t][u][v][w] = st.nextToken().toInt()

                                                if(map[m][n][o][p][q][r][s][t][u][v][w] == 1) {
                                                    queue.add(Tomato(m, n, o, p, q, r, s, t, u, v, w))
                                                } else if(map[m][n][o][p][q][r][s][t][u][v][w] == 0) {
                                                    restTomatoCount++
                                                }
                                            }
                                        }


    var day = 0

    while (queue.isNotEmpty()) {
        val size = queue.size
        day++

        for(si in 0 until size) {
            val tomato = queue.removeFirst()

            for(i in directions[0].indices) {
                val nm = tomato.dimension0 + directions[0][i]
                val nn = tomato.dimension1 + directions[1][i]
                val no = tomato.dimension2 + directions[2][i]
                val np = tomato.dimension3 + directions[3][i]
                val nq = tomato.dimension4 + directions[4][i]
                val nr = tomato.dimension5 + directions[5][i]
                val ns = tomato.dimension6 + directions[6][i]
                val nt = tomato.dimension7 + directions[7][i]
                val nu = tomato.dimension8 + directions[8][i]
                val nv = tomato.dimension9 + directions[9][i]
                val nw = tomato.dimension10 + directions[10][i]

                if(nm !in 0 until M ||
                    nn !in 0 until N ||
                    no !in 0 until O ||
                    np !in 0 until P ||
                    nq !in 0 until Q ||
                    nr !in 0 until R ||
                    ns !in 0 until S ||
                    nt !in 0 until T ||
                    nu !in 0 until U ||
                    nv !in 0 until V ||
                    nw !in 0 until W ||
                    map[nm][nn][no][np][nq][nr][ns][nt][nu][nv][nw] == 1 ||
                    map[nm][nn][no][np][nq][nr][ns][nt][nu][nv][nw] == -1)
                continue

                map[nm][nn][no][np][nq][nr][ns][nt][nu][nv][nw] = 1
                restTomatoCount--
                queue.add(Tomato(nm, nn, no, np, nq, nr, ns, nt, nu, nv, nw))
            }
        }
    }

    println(if(restTomatoCount == 0) day - 1 else -1)
}