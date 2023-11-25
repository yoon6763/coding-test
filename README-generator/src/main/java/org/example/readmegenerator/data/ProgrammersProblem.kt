package readmegenerator.platform.data

import org.example.readmegenerator.data.Problem

data class ProgrammersProblem(
    override val title: String,
    override val language: String,
    val level: Int,
) : Problem(title, language)