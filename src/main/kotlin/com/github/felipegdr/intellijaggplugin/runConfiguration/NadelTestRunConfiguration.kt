package com.github.felipegdr.intellijaggplugin.runConfiguration

import com.intellij.execution.Executor
import com.intellij.execution.configurations.*
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.ProcessHandlerFactory
import com.intellij.execution.process.ProcessTerminatedListener
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project


class NadelTestRunConfiguration(
    project: Project,
    factory: ConfigurationFactory,
    name: String
) : RunConfigurationBase<NadelTestRunConfigurationOptions>(project, factory, name) {

    var testName: String?
        get() = options.testName
        set(testName) {
            options.testName = testName
        }

    override fun checkConfiguration() {
    }

    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState? {
        return object : CommandLineState(environment) {
            override fun startProcess(): ProcessHandler {
                val commandLine = GeneralCommandLine("./gradlew nadel-test:test --tests \"graphql.nadel.tests.EngineTests\"")
                    .withEnvironment("TEST_NAME", "hydration within hydration with variables")
                val processHandler = ProcessHandlerFactory.getInstance().createColoredProcessHandler(commandLine)
                ProcessTerminatedListener.attach(processHandler)
                return processHandler
            }
        }
    }

    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration> {
        return NadelTestSettingsEditor()
    }

    override fun getOptions(): NadelTestRunConfigurationOptions {
        return super.getOptions() as NadelTestRunConfigurationOptions
    }


}