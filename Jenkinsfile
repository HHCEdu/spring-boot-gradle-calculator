pipeline {
    agent {
		node { label 'ubuntu-docker' }
	}
    stages {
    	stage("Compile") {
        	steps {
        		sh "./gradlew compileJava"
        	}
        }
        stage("Unit test") {
        	steps {
        		sh "./gradlew test"
        	}
        }
        stage("Code coverage") {
        	steps {
        		sh "./gradlew jacocoTestReport"
        		publishHTML (target: [
        			reportDir: 'build/reports/jacoco/test/html',
        			reportFiles: 'index.html',
        			reportName: 'JaCoCo Report'
        		])
        		sh "./gradlew jacocoTestCoverageVerification"
        	}
        }
        stage('Static Code Analysis'){
        	steps {
        		sh "./gradlew sonarqube -Dsonar.projectKey=spring-boot-gradle-calculator -Dsonar.host.url=http://129.213.112.244:9000 -Dsonar.login=0435adb5cb7f5bfab64ad9caecafd29260e377ea"
        	}
        }
        stage("Package") {
        	steps {
            	sh "./gradlew build"
        	}
		}
		stage("Docker build") {
 	       steps {
            	sh "sudo docker build -t localhost:5000/spring-boot-gradle-calculator ."
        	}
		}
		stage("Docker push") {
 	       steps {
            	sh "sudo docker push localhost:5000/spring-boot-gradle-calculator"
        	}
		}
		stage("Deploy to staging") {
        	steps {
            	sh "sudo docker run -d --rm -p 8090:8090 --name spring-boot-gradle-calculator localhost:5000/spring-boot-gradle-calculator"
			}
		}
		stage("Acceptance test") {
        	steps {
				sleep 60
             	sh "chmod +x acceptance_test.sh && ./acceptance_test.sh"
        	}
		}
    }
    post {
        always {
             sh "sudo docker stop spring-boot-gradle-calculator"
    	}
	}
}
