pipeline {
	agent {
		docker { image 'maven-build-slave-0.1' }
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
    }
}
