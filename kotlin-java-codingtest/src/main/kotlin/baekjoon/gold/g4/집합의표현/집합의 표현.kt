package baekjoon.gold.g4.집합의표현

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

lateinit var parent: Array<Int>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val nm = br.readLine().split(" ")
    val n = nm[0].toInt()
    val m = nm[1].toInt()

    // 각 원소의 부모
    parent = Array(n + 1) { it }

    repeat(m) {
        val st = StringTokenizer(br.readLine())
        // 0 a b -> a, b 합집합
        // 1 a b -> a, b 같은 집합인지 확인

        val oper = st.nextToken().toInt() // 연산자
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        // 0 연산 (합집합) -> union
        if(oper == 0) {
            union(a, b)
        } else {
            // 1 연산 (같은 집합에 속하는지) -> 부모가 같은지 확인
            if(find(a) == find(b)) {
                sb.append("YES\n")
            } else {
                sb.append("NO\n")
            }
        }
    }
    print(sb)
}

// 원소의 부모를 찾는 과정
// x와 x의 부모가 같음 (부모가 자기 자신) -> 반환
// x와 x의 부모가 다름 -> x의 부모를 매개변수로 재귀적으로 수행
fun find(x: Int): Int {
    return if (parent[x] == x) x
    else {
        parent[x] = find(parent[x])
        parent[x]
    }
}

// 두 원소의 부모를 찾고, 둘이 같게 만들어줌
fun union(x: Int, y: Int) {
    val nx = find(x)
    val ny = find(y)

    if (nx != ny) {
        parent[ny] = nx
    }
}