import java.io.File

data class ProblemInfo(val problemName: String, val language: String)
data class BaekjoonProblem(val problemInfo: ProblemInfo, val tier: String, val level: Int)
data class ProgrammersProblem(val problemInfo: ProblemInfo, val level: Int)

val bojProblems = mutableListOf<BaekjoonProblem>()
val programmersProblems = mutableListOf<ProgrammersProblem>()

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

val tierList = listOf(
    "diamond",
    "platinum",
    "gold",
    "silver",
    "bronze",
    "unrated"
)

val languageCount = hashMapOf<String, Int>()

val tierLevelList = ArrayList<String>()

fun main() {
    val javaKotlinPath = System.getProperty("user.dir")
    val defaultPath = File(javaKotlinPath).parent

    for (tier in tierList) {
        for (level in 1..5) {
            tierLevelList.add("${tier[0]}$level")
        }
    }
    for (i in 0..5) {
        tierLevelList.add("lv$i")
    }

    countSolvedProblems(defaultPath, 0, "", -1, "")
    sortProblemList()
    updateReadMe(defaultPath)
}

fun sortProblemList() {
    val tierPriority = hashMapOf<String, Int>()
    tierList.forEachIndexed { index, s -> tierPriority[s] = index }

    bojProblems.sortWith(
        compareBy(
            { tierPriority[it.tier] },
            { it.level },
            { -languageCount[it.problemInfo.language]!! })
    )
    programmersProblems.sortWith(compareBy({ -it.level }, { -languageCount[it.problemInfo.language]!! }))
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

    content.appendLine()
    content.appendLine("```")
    content.appendLine("Solved Problems : ${bojProblems.size + programmersProblems.size}")
    languageCount.toList().sortedByDescending { it.second }.forEach {
        content.appendLine(" - ${it.first} : ${it.second}")
    }
    content.appendLine()


    content.appendLine("Baekjoon")
    bojProblems.groupBy { it.tier }.forEach { tier ->
        content.appendLine("\t${tier.key}")

        tier.value.groupBy { it.level }.forEach { problem ->
            content.appendLine("\t\t${tier.key[0]}${problem.key}")

            problem.value.forEach { problem ->
                content.appendLine("\t\t\t[${problem.problemInfo.language}] - ${problem.problemInfo.problemName}")
            }
            content.appendLine()
        }

        content.appendLine()
    }

    content.appendLine("Programmers")

    programmersProblems.groupBy { it.level }.forEach { problem ->
        content.appendLine("\tlv. ${problem.key}")

        problem.value.forEach { problem ->
            content.appendLine("\t\t[${problem.problemInfo.language}] - ${problem.problemInfo.problemName}")
        }
        content.appendLine()
    }

    content.appendLine("```")

    println(content)
    readMe.writeText(content.toString())
}

fun countSolvedProblems(
    path: String,
    deep: Int,
    tier: String,
    level: Int,
    type: String
) {
    val baseFolder = File(path)
    val lastPath = baseFolder.name

    var type = type
    if (type == "" && (lastPath == "baekjoon" || lastPath == "programmers")) type = lastPath
    var tier = tier
    if (tier == "" && tierList.contains(lastPath)) tier = lastPath
    var level = level
    if (level == -1 && tierLevelList.contains(lastPath)) level = lastPath.filter { it.isDigit() }.toInt()

    baseFolder.list()?.forEach { path ->
        repeat(deep) { print("\t") }

        val file = File("${baseFolder.path}/$path")
        if (file.isFile && file.extension in extension && type != "") {
            val problemName = file.nameWithoutExtension
            val language = extension[file.path.split(".").last()]!!
            val problemInfo = ProblemInfo(problemName, language)

            languageCount[language] = languageCount.getOrDefault(language, 0) + 1

            when (type) {
                "baekjoon" -> bojProblems.add(BaekjoonProblem(problemInfo, tier, level))
                "programmers" -> programmersProblems.add(ProgrammersProblem(problemInfo, level))
            }
        }

        countSolvedProblems("${baseFolder.path}/$path", deep + 1, tier, level, type)
    }
}


fun StringBuilder.appendLineForMarkdown(line: String) {
    this.append(line)
    this.appendLine("<br/>")
}

fun StringBuilder.appendLineForMarkdown() {
    this.appendLine("<br/>")
}