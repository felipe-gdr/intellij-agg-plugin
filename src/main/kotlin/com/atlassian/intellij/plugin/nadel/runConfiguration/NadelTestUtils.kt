package com.atlassian.intellij.plugin.nadel.runConfiguration

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement

fun PsiElement.isInFixtureFile(): Boolean {
    val directory = this.containingFile?.containingDirectory ?: return false

    val isInFixtureDir = (
        directory.name.contains(NadelTestConstants.FIXTURES_DIR_NAME) ||
            directory.parentDirectory?.name?.contains(NadelTestConstants.FIXTURES_DIR_NAME) ?: false
        )

    return this.isInYamlFile() && isInFixtureDir
}

fun PsiElement.isInYamlFile(): Boolean {
    return this.containingFile.name.endsWith("yml") || this.containingFile.name.endsWith("yaml")
}

fun Project.isNadelProject(): Boolean {
    return this.name == NadelTestConstants.NADEL_PROJECT_NAME
}
