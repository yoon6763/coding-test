package readmegenerator.platform

import readmegenerator.Config
import readmegenerator.GeneratorModeHelper
import readmegenerator.platform.data.GroomthonChallengeProblem
import java.io.File

class GroomthonChallenge : Platform {

    override val platformName: String = "groomthonchallenge"
    private val problems = mutableListOf<GroomthonChallengeProblem>()

    override fun problemAdd(file: File): Boolean {
        val path = file.path
        return isValidate(path)
    }

    override fun isValidate(path: String): Boolean {
        val pathList = path.split(GeneratorModeHelper.getPathSplitter())
        if (platformName !in path) return false

        val extension = pathList.last().split(".").last()
        if (extension !in Config.supportLanguage) return false

        val level = pathList[pathList.indexOf(platformName) + 1].filter { it.isDigit() }.toIntOrNull() ?: return false
        val language = Config.supportLanguage[extension] ?: return false
        val title = pathList.last().split(".").first()

        problems.add(GroomthonChallengeProblem(title, level, language))
        return true
    }

    override fun generateReadmeContent(): String {
        sortProblemList()

        val sb = StringBuilder()
        sb.appendLine("Groomthon Challenge")

        problems.groupBy { it.level }.forEach { (level, problems) ->
            sb.appendLine("  Level $level")
            problems.forEach { problem ->
                sb.appendLine("    [${problem.language}] ${problem.title}")
            }
            sb.appendLine()
        }

        return sb.toString()
    }

    override fun sortProblemList() {
        val languageCount = mutableMapOf<String, Int>()
        problems.forEach {
            languageCount[it.language] = languageCount.getOrDefault(it.language, 0) + 1
        }

        problems.sortWith(compareBy({ -it.level }, { -languageCount[it.language]!! }))
    }

    override fun getProblemInfoList(): List<ProblemInfo> {
        return problems.map { ProblemInfo(it.title, platformName, it.language) }
    }
}