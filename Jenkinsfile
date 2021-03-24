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
    }
}
