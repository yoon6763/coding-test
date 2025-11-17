package baekjoon.silver.s3.`가희와 파일 탐색기`

import java.util.*

class File(val name: String, val ext: String, private var osExt: Int) : Comparable<File> {
    override operator fun compareTo(o: File): Int {
        return if (name == o.name) {
            if (osExt == o.osExt) {
                ext.compareTo(o.ext)
            } else o.osExt.compareTo(osExt)
        } else name.compareTo(o.name)
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()

    //초기화
    val filenames = ArrayList<String>()
    val osExts = HashSet<String>()

    for (i in 0 until a) {
        filenames.add(readLine())
    }

    for (i in 0 until b) {
        osExts.add(readLine())
    }

    val pq = PriorityQueue<File>()
    for (i in 0 until a) {
        st = StringTokenizer(filenames[i], ".")
        val name = st.nextToken()
        val ext = st.nextToken()
        pq.offer(File(name, ext, if (osExts.contains(ext)) 1 else 0))
    }

    val sb = StringBuilder()

    while (!pq.isEmpty()) {
        val target = pq.poll()
        sb.append(target.name).append(".").append(target.ext).append("\n")
    }
    print(sb)
}

