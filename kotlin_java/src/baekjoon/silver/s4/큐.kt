package baekjoon.silver.s4

fun main() {
    var right = -1
    var left = 0
    val queue: Array<Int>

    val n = readLine()!!.toInt()
    queue = Array(n) { 0 }

    repeat(n) {
        when (val input = readLine()!!) {
            "pop" -> {
                if (left > right) {
                    println(-1)
                } else {
                    println(queue[left++])
                }
            }

            "size" -> {
                if (left > right) {
                    println(0)
                } else {
                    println(right - left + 1)
                }
            }

            "empty" -> {
                println(if (left > right) 1 else 0)
            }

            "front" -> {
                if (left > right) {
                    println(-1)
                } else {
                    println(queue[left])
                }
            }

            "back" -> {
                if (left > right) {
                    println(-1)
                } else {
                    println(queue[right])
                }
            }

            // Push X
            else -> {
                val number = input.split(" ")[1].toInt()
                queue[++right] = number
            }
        }
    }
}

/*
        push X: 정수 X를 큐에 넣는 연산이다.
        pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        size: 큐에 들어있는 정수의 개수를 출력한다.
        empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
        front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */