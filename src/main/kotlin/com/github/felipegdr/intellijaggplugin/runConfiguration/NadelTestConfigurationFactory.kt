package com.github.felipegdr.intellijaggplugin.runConfiguration

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationType
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.openapi.components.BaseState
import com.intellij.openapi.project.Project

class NadelTestConfigurationFactory(type: ConfigurationType) : ConfigurationFactory(type) {
    override fun createTemplateConfiguration(project: Project): RunConfiguration {
        return NadelTestRunConfiguration(project, this, "Demo?")
    }

    override fun getId(): String {
        return NadelTestRunConfigurationType.ID
    }

    override fun getOptionsClass(): Class<out BaseState> {
        return NadelTestRunConfigurationOptions::class.java
    }
}