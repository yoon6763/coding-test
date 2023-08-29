package baekjoon.gold.g2.물통

class State(val a: Int, val b: Int, val depth: Int = 0) {
    override fun equals(other: Any?): Boolean {
        if (other !is State) return false
        return a == other.a && b == other.b
    }

    override fun hashCode(): Int {
        var result = a
        result = 31 * result + b
        result = 31 * result + depth
        return result
    }
}

fun main() {
    val (capacityA, capacityB, targetA, targetB) = readln().split(" ").map { it.toInt() }

    val visited = HashSet<State>()
    val queue = ArrayDeque<State>()

    queue.add(State(0, 0, 0))
    visited.add(State(0, 0, 0))

    while (queue.isNotEmpty()) {
        val target = queue.removeFirst()

        if (target.a == targetA && target.b == targetB) {
            println(target.depth)
            return
        }

        // 가득 채움
        if (State(capacityA, target.b) !in visited) {
            queue.add(State(capacityA, target.b, target.depth + 1))
            visited.add(State(capacityA, target.b))
        }

        if (State(target.a, capacityB) !in visited) {
            queue.add(State(target.a, capacityB, target.depth + 1))
            visited.add(State(target.a, capacityB))
        }


        // 버림
        if (State(0, target.b) !in visited) {
            queue.add(State(0, target.b, target.depth + 1))
            visited.add(State(0, target.b))
        }

        if (State(target.a, 0) !in visited) {
            queue.add(State(target.a, 0, target.depth + 1))
            visited.add(State(target.a, 0))
        }

        // 다른 물통에 부움
        if (target.a > 0) {
            val pour = minOf(capacityB - target.b, target.a)
            if (State(target.a - pour, target.b + pour) !in visited) {
                queue.add(State(target.a - pour, target.b + pour, target.depth + 1))
                visited.add(State(target.a - pour, target.b + pour))
            }
        }

        if (target.b > 0) {
            val pour = minOf(capacityA - target.a, target.b)
            if (State(target.a + pour, target.b - pour) !in visited) {
                queue.add(State(target.a + pour, target.b - pour, target.depth + 1))
                visited.add(State(target.a + pour, target.b - pour))
            }
        }
    }

    println(-1)
}