pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "EchoAI"

// 核心应用模块
include(":app")

// 原项目包含的其他子模块 (如果编译提示找不到某个模块，请把缺失的 include(":xxx") 加回来)
include(":aci-app")
include(":aidl-aci-browser")
include(":aidl-aci-core")
include(":genuiagent-sdk")
include(":kaleidobox")
include(":plugin-contract")
include(":plugin-engine")
include(":plugin-express")
include(":plugin-devkit")
include(":plugin-signcheck")
include(":terminal-core")
include(":lib_aci")
include(":cap_main")
include(":llama")
include(":mnn")
include(":mini-app-sdk")
include(":plugin-zorvWeb")
include(":plugin-sysinfo")
include(":plugin-units")
include(":plugin-todo")
