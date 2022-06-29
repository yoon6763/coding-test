import java.io.File

var cnt = 0

fun main() {
    val defaultPath = System.getProperty("user.dir")
    val codePath = "${defaultPath}/Java&Kotlin/src"


    dfs(codePath, 0)
    println(cnt)
}

fun dfs(path: String, deep: Int) {
    val folder = File(path)

    folder.list()?.forEach {
        repeat(deep) { print("\t") }
        println(it)

        if ((folder.path.contains("programmers") || folder.path.contains("baekjoon"))
            && (it.endsWith(".kt") || it.endsWith(".java"))
        )
            cnt++

        dfs("${folder.path}/$it", deep + 1)
    }
}