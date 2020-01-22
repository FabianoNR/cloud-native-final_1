node {

    def server = Artifactory.server "jfrog"

    def rtGradle = Artifactory.newGradleBuild()
    def buildInfo


	stage('download source code') {
         steps {
            git 'https://github.com/fabianorapkiewicz/cloud-native-final_1.git'
         }
    }

    stage('Artifactory configuration') {

        rtGradle.tool = "Gradle-6.1"

        rtGradle.deployer repo:'gradle-dev-local', server: server
        rtGradle.resolver repo:'jcenter', server: server
    }

	stage('Run Test') {
        buildInfo = rtGradle.run rootDir: "", buildFile: 'build.gradle', tasks: 'test'
    }

    stage('Run Build') {
        buildInfo = rtGradle.run rootDir: "", buildFile: 'build.gradle', tasks: 'clean artifactoryPublish'
    }

    stage('Publish build info') {
        server.publishBuildInfo buildInfo
    }
}