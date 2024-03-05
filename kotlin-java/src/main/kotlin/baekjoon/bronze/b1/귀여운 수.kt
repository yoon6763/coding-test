package baekjoon.bronze.b1


fun main() {
    val nums = readln().toCharArray().map { it.toString().toInt() }
    if(nums.size <= 2) {
        println("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!")
        return
    }

    val diff = nums[1] - nums[0]
    for(i in 1..<nums.size - 1) {
        if(nums[i + 1] - nums[i] != diff) {
            println("흥칫뿡!! <(￣ ﹌ ￣)>")
            return
        }
    }

    println("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!")
}