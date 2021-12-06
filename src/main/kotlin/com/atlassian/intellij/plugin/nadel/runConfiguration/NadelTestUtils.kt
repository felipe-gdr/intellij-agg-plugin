package com.atlassian.intellij.plugin.nadel.runConfiguration

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiElement

fun PsiElement.isInFixtureFile(): Boolean {
    val directory = this.containingFile?.containingDirectory ?: return false

    val isInFixtureDir = isInFixtureDirectoryHierarchy(directory)

    return this.isInYamlFile() && isInFixtureDir
}

@Suppress("ReturnCount")
private fun isInFixtureDirectoryHierarchy(directory: PsiDirectory?): Boolean {
    if (directory == null) {
        return false
    }

    if (directory.name.contains(NadelTestConstants.FIXTURES_DIR_NAME)) {
        return true
    }

    return isInFixtureDirectoryHierarchy(directory.parentDirectory)
}

fun PsiElement.isInYamlFile(): Boolean {
    return this.containingFile.name.endsWith("yml") || this.containingFile.name.endsWith("yaml")
}

fun Project.isNadelProject(): Boolean {
    return this.name == NadelTestConstants.NADEL_PROJECT_NAME
}
