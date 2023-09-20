package readmegenerator.mode

import readmegenerator.Config
import java.io.File

object GeneratorModeHelper {

    private val generatorMode = Config.generatorMode

    fun getDefaultPath(): String = when (generatorMode) {
        GeneratorMode.LOCAL_DEVELOP_WINDOWS, GeneratorMode.LOCAL_DEVELOP_MAC -> File(System.getProperty("user.dir")).parent
        GeneratorMode.GITHUB_ACTIONS -> "/home/runner/work/coding-test/coding-test"
    }

    fun getPathSplitter() = when (generatorMode) {
        GeneratorMode.LOCAL_DEVELOP_WINDOWS -> "\\"
        GeneratorMode.LOCAL_DEVELOP_MAC, GeneratorMode.GITHUB_ACTIONS -> "/"
    }
}