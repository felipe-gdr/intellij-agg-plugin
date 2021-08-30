package com.github.felipegdr.intellijaggplugin.services

import com.github.felipegdr.intellijaggplugin.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
