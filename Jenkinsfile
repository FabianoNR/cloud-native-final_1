node {

    def server = Artifactory.server "jfrog"

    def rtGradle = Artifactory.newGradleBuild()
    def buildInfo

    stage('Artifactory configuration') {

        rtGradle.tool = "Gradle-6.1"

        rtGradle.deployer repo:'gradle-dev-local', server: server
        rtGradle.resolver repo:'jcenter', server: server
    }

    stage('Gradle build') {
        buildInfo = rtGradle.run rootDir: "", buildFile: 'build.gradle', tasks: 'clean test artifactoryPublish'
    }

    stage('Publish build info') {
        server.publishBuildInfo buildInfo
    }
}