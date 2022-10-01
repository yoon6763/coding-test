package baekjoon.silver.s4

fun main() {
    var input = readLine()!!.split(" ")
    val numberOfEgg = input[0].toInt()
    val numberOfCustomer = input[1].toInt()

    var nums = arrayOfNulls<Int>(numberOfCustomer)

    for (i in 0 until numberOfCustomer)
        nums[i] = readLine()!!.toInt()

    nums.sort()
    nums.reverse()

    var max = 0
    var value = 0

    for (i in nums.indices) {
        if (i > numberOfEgg - 1)
            break

        var temp = nums[i]!! * (i + 1)
        if (temp >= max) {
            value = nums[i]!!
            max = temp
        }
    }

    print("$value $max")
}