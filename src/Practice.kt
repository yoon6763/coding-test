fun main() {

    val arr1 = Array(3) { Array(3) { 0 } }
    val arr2 = Array(3) { Array(3) { 0 } }

    for(i in 0 until 3) {
        arr2[i] = arr1[i].copyOf()
    }

    arr2[2][2] = 3
    arr2[1][1] = 23
    arr1[2][0] = -3

    arr1.forEach {
        println(it.contentToString())
    }

    println()

    arr2.forEach {
        println(it.contentToString())
    }

}
