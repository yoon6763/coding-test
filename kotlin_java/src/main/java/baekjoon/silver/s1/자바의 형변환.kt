package baekjoon.silver.s1

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().trim().toInt()
    val tree = HashMap<String, String>()

    for (i in 1..<n) {
        val (p, c) = readLine().trim().split(" ")
        tree[p] = c
    }

    val (target1, target2) = readLine().trim().split(" ")

    val solve = bfs@{ tree: HashMap<String, String>, target1: String, target2: String ->
        var cur = target1

        while (true) {
            cur = tree[cur] ?: return@bfs 0
            if (cur == target2) {
                return@bfs 1
            }
        }
        0
    }

    println(solve(tree, target1, target2) or solve(tree, target2, target1))
}
