package baekjoon.bronze.b1

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val (name1, name2) = readln().split(" ")

    //알파벳	A	B	C	D	E	F	G	H	I	J	K	L	M	N	O	P	Q	R	S	T	U	V	W	X	Y	Z
    //획수	3	2	1	2	4	3	1	3	1	1	3	1	3	2	1	2	2	2	1	2	1	1	1	2	2	1

    val map = mapOf(
        'A' to 3, 'B' to 2, 'C' to 1, 'D' to 2,
        'E' to 4, 'F' to 3, 'G' to 1, 'H' to 3,
        'I' to 1, 'J' to 1, 'K' to 3, 'L' to 1,
        'M' to 3, 'N' to 2, 'O' to 1, 'P' to 2,
        'Q' to 2, 'R' to 2, 'S' to 1, 'T' to 2,
        'U' to 1, 'V' to 1, 'W' to 1, 'X' to 2,
        'Y' to 2, 'Z' to 1
    )

    var name = ""

    for (i in 0..<maxOf(name1.length, name2.length)) {
        if (i < name1.length) name += name1[i]
        if (i < name2.length) name += name2[i]
    }

    val arr = name.map { map[it]!! }.toMutableList()

    while (arr.size > 2) {
        val temp = mutableListOf<Int>()
        for (i in 0..<arr.size - 1) {
            temp.add((arr[i] + arr[i + 1]) % 10)
        }
        arr.clear()
        arr.addAll(temp)
    }

    if(arr[0] == 0) println("${arr[1]}%")
    else println("${arr[0]}${arr[1]}%")
}