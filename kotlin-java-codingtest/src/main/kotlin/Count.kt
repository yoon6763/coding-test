import java.io.File

enum class Type {
    PROGRAMMERS, BAEKJOON
}

data class Problem(val problemName: String, val language: String, val level: String, val type: Type)

var count = HashMap<String, Int>()
val extension = hashMapOf(
    "a68" to "algol68",
    "c" to "C",
    "cpp" to "C++",
    "java" to "Java",
    "kt" to "Kotlin",
    "f95" to "Fortran",
    "bas" to "FreeBASIC",
    "gs" to "GolfScript",
    "js" to "JavaScript",
    "py" to "Python",
    "rb" to "Ruby",
    "sql" to "SQL",
    "vb" to "Visual Basic",
)

fun main() {
    val javaKotlinPath = System.getProperty("user.dir")
    val defaultPath = File(javaKotlinPath).parent

    countSolvedProblems(defaultPath, 0)
    updateReadMe(defaultPath)
}

fun updateReadMe(defaultFile: String) {
    val readMe = File("$defaultFile/README.md")
    val content = StringBuilder()

    val bufferedReader = readMe.bufferedReader()

    while (true) {
        val line = bufferedReader.readLine() ?: break
        content.appendLine(line)
        if (line.contains("## Solved Problems")) break
    }

    count.toList().sortedByDescending { it.second }.forEach {
        content.appendLine("- ${extension[it.first]}: ${it.second} 문제")
    }


    readMe.writeText(content.toString())
}

fun countSolvedProblems(path: String, deep: Int) {
    val folder = File(path)

    println(folder.path)

    folder.list()?.forEach {
        repeat(deep) { print("\t") }

        if (folder.path.contains("programmers") || folder.path.contains("baekjoon")) {
            val ext = it.split(".").last()
            if (ext in extension.map { it.key }) {
                count[ext] = count.getOrDefault(ext, 0) + 1
                println(it)
            }
        }

        countSolvedProblems("${folder.path}/$it", deep + 1)
    }
}