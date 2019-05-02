pipeline {
    agent any

    stages {
        stage ('Compile Stage') {
            steps{
                bat 'set classpath=%~dp0\bin;%~dp0\lib'
                bat 'java org.testng.TestNG %~dp0testng.xml'
                withMaven(maven : 'maven_3_6_0'){
                    sh 'mvn clean package && cp target/ic-0.0.1-SNAPSHOT.jar ./ && gcloud app deploy --stop-previous-version'
                }
            }
        }
    }
}
