pipeline {
	agent any
    stages {
    	stage("Compile") {
        	steps {
			sh "sdk use java 11.0.9.hs-adpt"
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
