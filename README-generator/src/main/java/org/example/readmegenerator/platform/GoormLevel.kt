package readmegenerator.platform

import readmegenerator.Config
import readmegenerator.platform.data.GroomthonChallengeProblem

class GoormLevel : Platform {
    val supportLanguage = Config.supportLanguage

    override val platformName: String = "goormlevel"
    private val problems = mutableListOf<GroomthonChallengeProblem>()

    override fun addProblem(path: String) {
        val splitPath = separatePath(path)

        val fileName = splitPath.last()
        val title = fileName.split(".").first()
        val extension = fileName.split(".").last()
        val language = supportLanguage[extension] ?: return

        val level = splitPath[splitPath.indexOf(platformName) + 1].filter { it.isDigit() }.toIntOrNull() ?: return

        problems.add(GroomthonChallengeProblem(title, language, level))
    }

    override fun generateReadmeContent(): String {
        val sb = StringBuilder()
        sb.appendLine("goorm level")

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

        problems.sortWith(
            compareBy(
                { -it.level },
                { -languageCount[it.language]!! },
                { it.title }
            )
        )
    }

    override fun getProblemInfoList(): List<ProblemInfo> {
        return problems.map { ProblemInfo(it.title, platformName, it.language) }
    }
}