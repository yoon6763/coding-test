package goormlevel.lv2.`연속 점수`

fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map{it.toLong()}

    var ans = 0L
    var sum = arr[0]
    var index = 1

    while(index < n) {
        if(arr[index - 1] + 1 == arr[index]) {
            sum += arr[index]
        } else {
            ans = maxOf(ans, sum)
            sum = arr[index]
        }
        index++
    }

    println(maxOf(ans, sum))
}