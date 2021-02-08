package com.github.himcs.ideapluginleetcode.services

import com.github.himcs.ideapluginleetcode.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
