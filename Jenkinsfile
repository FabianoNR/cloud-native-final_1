node {

    def server = Artifactory.server "jfrog"

    def rtGradle = Artifactory.newGradleBuild()
    def buildInfo

	stage ('Clone') {
        git url: 'https://github.com/JFrog/project-examples.git'
    }

    stage('Artifactory configuration') {

        rtGradle.tool = "Gradle-6.1"

        rtGradle.deployer repo:'gradle-dev-local', server: server
        rtGradle.resolver repo:'jcenter', server: server
    }


    stage('Run Build') {
        buildInfo = rtGradle.run rootDir: ".", buildFile: 'build.gradle', tasks: 'clean artifactoryPublish'
    }

    stage('Publish build info') {
        server.publishBuildInfo buildInfo
    }
}