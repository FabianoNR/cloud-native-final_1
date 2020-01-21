pipeline {
	agent any
	stages {
		stage('Test') {
		   steps {
   		    	echo 'Testing...'
   		    	sh './gradlew test'
   			}
		}
		stage('Build') {
			steps {
				echo 'Building...'
				sh './gradlew clean build'
			}
		}
		stage('Deploy') {
		   steps {
   		    	echo 'Deploying...'
   			}
		}
	}
}