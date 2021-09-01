package com.atlassian.intellij.plugin.nadel.runConfiguration

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationType
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.openapi.project.Project
import org.jetbrains.plugins.gradle.service.execution.GradleRunConfiguration

class NadelTestConfigurationFactory(type: ConfigurationType) : ConfigurationFactory(type) {
    override fun createTemplateConfiguration(project: Project): RunConfiguration {
        val config = GradleRunConfiguration(project, this, "Run Nadel test")

        config.settings.externalProjectPath = project.basePath?.let { "$it/test" }
        config.settings.taskNames = listOf("test")
        config.settings.scriptParameters = "--tests \"graphql.nadel.tests.EngineTests\""

        return config
    }

    override fun isApplicable(project: Project): Boolean {
        return project.isNadelProject()
    }

    override fun getId(): String {
        return NadelTestRunConfigurationType.ID
    }
}
