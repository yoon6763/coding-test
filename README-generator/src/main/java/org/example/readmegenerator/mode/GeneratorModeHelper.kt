package readmegenerator.mode

import org.example.readmegenerator.mode.GenerateMode
import readmegenerator.Config
import java.io.File

object GeneratorModeHelper {

    private val generatorMode = Config.generatorMode

    fun getDefaultPath(): String = when (generatorMode) {
        GenerateMode.LOCAL_DEVELOP_WINDOWS -> File(System.getProperty("user.dir")).parent
        GenerateMode.GITHUB_ACTIONS, GenerateMode.LOCAL_DEVELOP_MAC -> "/home/runner/work/coding-test/coding-test"
    }

    fun getPathSplitter() = when (generatorMode) {
        GenerateMode.LOCAL_DEVELOP_WINDOWS -> "\\"
        GenerateMode.LOCAL_DEVELOP_MAC, GenerateMode.GITHUB_ACTIONS -> "/"
    }
}