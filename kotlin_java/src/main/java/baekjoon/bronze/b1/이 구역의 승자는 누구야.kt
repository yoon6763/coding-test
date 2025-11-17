package baekjoon.bronze.b1

fun main()=print(if (readln().sumOf { arrayOf(3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1)[it - 'A'] } % 2 == 0) "You're the winner?" else "I'm a winner!")