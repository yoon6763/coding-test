package readmegenerator.platform

import readmegenerator.Config
import readmegenerator.mode.GeneratorModeHelper
import readmegenerator.platform.data.BaekjoonProblem
import java.io.File

class Baekjoon : Platform {

    val supportLanguage = Config.supportLanguage

    override val platformName: String = "baekjoon"
    private val problems = mutableListOf<BaekjoonProblem>()
    private val tierList = listOf("diamond", "platinum", "gold", "silver", "bronze", "unrated")

    override fun problemAdd(file: File): Boolean {
        val path = file.path
        return isValidate(path)
    }

    override fun isValidate(path: String): Boolean {
        val pathList = path.split(GeneratorModeHelper.getPathSplitter())
        if (platformName !in path) return false

        val extension = pathList.last().split(".").last()
        if (extension !in supportLanguage) return false

        val tier = pathList[pathList.indexOf(platformName) + 1]
        if (tier !in tierList) return false

        val level = pathList[pathList.indexOf(platformName) + 2].filter { it.isDigit() }.toIntOrNull() ?: return false

        val language = supportLanguage[extension] ?: return false
        val title = pathList.last().split(".").first()

        problems.add(BaekjoonProblem(title, tier, level, language))
        return true
    }

    override fun generateReadmeContent(): String {
        sortProblemList()

        val sb = StringBuilder()
        sb.appendLine(platformName)

        problems.groupBy { it.tier }.forEach { (tier, problems) ->
            sb.appendLine("  $tier")
            problems.groupBy { it.level }.forEach { (level, problems) ->
                sb.appendLine("    ${tier[0]}$level")
                problems.forEach { problem ->
                    sb.appendLine("      [${problem.language}] ${problem.title.replace("_", " ")}")
                }
            }
            sb.appendLine()
        }

        return sb.toString()
    }

    override fun sortProblemList() {
        val languageCount = mutableMapOf<String, Int>()
        val tierPriority = Array(tierList.size) { Pair(tierList[it], it) }.toMap()

        problems.forEach {
            languageCount[it.language] = languageCount.getOrDefault(it.language, 0) + 1
        }

        problems.sortWith(compareBy(
            { tierPriority[it.tier] },
            { it.level },
            { -languageCount[it.language]!! },
            { it.title }
        ))
    }

    override fun getProblemInfoList(): List<ProblemInfo> {
        return problems.map { ProblemInfo(it.title, platformName, it.language) }
    }
}