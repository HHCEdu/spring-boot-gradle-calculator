pipeline {
    agent {
		docker { image 'gradle-build-slave-0.1' }
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
        stage('Static Code Analysiss'){
        	sh "./gradlew sonarqube -Dsonar.projectKey=spring-boot-gradle-calculator -Dsonar.host.url=http://129.213.112.244:9000 -Dsonar.login=0435adb5cb7f5bfab64ad9caecafd29260e377ea"
        }
    }
}
