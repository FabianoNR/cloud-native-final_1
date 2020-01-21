pipeline {
	agent any
	stages {
		stage('Build') {
			steps {
				echo 'Building...'
				sh 'make'
				archiveArtifacts artifacts: '**/target/*.war', fingerprint: true
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