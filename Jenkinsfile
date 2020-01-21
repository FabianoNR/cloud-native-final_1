pipeline {
	agent any
	stages {
		stage('Build') {
			steps {
				echo 'Building...'
				sh 'make'
				archiveArtifacts artifact: '**/target/*.war', fingerprint: true
			}
		}
		stage('Test') {
		   steps {
   		    	echo 'Testing...'
   			}
		}
		stage('Deploy') {
		   steps {
   		    	echo 'Deploying...'
   			}
		}
	}
}