pipeline {
	agent any
	stages {
		stage('Build') {
			steps {
				echo 'Building...'
				sh './gradlew clean build'
			}
		}
		stage('Test') {
		   steps {
   		    	echo 'Testing...'
   		    	sh 'make check || true'
   		    	junit '**/target/*.xml'
   			}
		}
		stage('Deploy') {
		   steps {
   		    	echo 'Deploying...'
   			}
		}
	}
}