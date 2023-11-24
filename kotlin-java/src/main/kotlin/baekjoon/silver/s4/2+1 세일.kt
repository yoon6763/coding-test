package baekjoon.silver.s4

fun main() =
    print(Array(readln().toInt()) { readln().toInt() }
        .sortedDescending() // 내림차순 정렬
        .filterIndexed { i, _ -> i % 3 != 2 } // 3의 배수가 아닌 것만 필터링
        .sum()) // 필터링한 값들의 합 출력