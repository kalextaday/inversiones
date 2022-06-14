pipeline {
	//where and how to execute the Pipeline
	agent {
		label 'Slave_Induccion'
	}
	
	options {
		buildDiscarder(logRotator(numToKeepStr: '5')) 
		disableConcurrentBuilds() 
	}
	
	//A section defining tools to auto-install and put on the PATH
	tools {
		jdk 'JDK8_Centos'
	}

	triggers {
		pollSCM('@hourly')
	}
	
	stages{
		
		stage('Checkout') {
			steps{
				echo "------------>Checkout<------------"
				checkout scm
			}
		}

		stage('Unit Tests') {
        			steps{
        				echo "------------>Unit Tests<------------"
        				chmod +x gradlew
        				sh './gradlew clean test --no-daemon'
        			}
        		}
		/*
		stage('Compile') {
			steps{
				echo "------------>Compile<------------"
				sh 'gradle --b ./build.gradle compileJava'
			}
		}
		*/
		
		stage('Unit Tests And Coverage') {
			steps{
				echo "------------>Unit Tests<------------"
				sh 'gradle --b ./build.gradle test'
				junit '**/build/test-results/test/*.xml' //aggregate test results - JUnit
			    sh 'gradle --b ./build.gradle jacocoTestReport'
			}
		}
		
		stage('Static Code Analysis') {
			steps{
				echo '------------>Static Code Analysis<------------'
				withSonarQubeEnv('Sonar') {
					sh "${tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
				}
			}
		}
		
		stage('Build') {
			steps {
				echo "------------>Build<------------"
				sh 'gradle build -x test'
			}
		}
	}
	
	post {
		always {
			echo 'This will always run'
		}
		success {
			echo 'This will run only if successful'
		}
		failure {
			echo 'This will run only if failed'
			//send notifications about a Pipeline to an email
			mail (to: 'kevin.taday@ceiba.com.co',
			      subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
			      body: "Something is wrong with ${env.BUILD_URL}")
		}
		unstable {
			echo 'This will run only if the run was marked as unstable'
		}
		changed {
			echo 'This will run only if the state of the Pipeline has changed'
			echo 'For example, if the Pipeline was previously failing but is now successful'
		}
	}
}
