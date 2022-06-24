import java.io.File

fun main() {
    val defaultPath = System.getProperty("user.dir")
    dfs(defaultPath, 0)
}

fun dfs(path: String, deep: Int) {
    val folder = File(path)

    folder.list()?.forEach {
        repeat(deep) { print("\t") }
        println(it)

        dfs("${folder.path}/$it", deep + 1)
    }
}