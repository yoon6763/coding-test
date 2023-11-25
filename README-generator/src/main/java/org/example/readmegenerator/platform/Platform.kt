package readmegenerator.platform

import readmegenerator.mode.GeneratorModeHelper

interface Platform {

    fun separatePath(path: String): List<String> {
        return path.split(GeneratorModeHelper.getPathSplitter())
    }

    val platformName: String

    fun generateReadmeContent(): String
    fun getProblemInfoList(): List<ProblemInfo>
    fun sortProblemList()
    fun addProblem(path: String)
}