pipeline {
    agent any

    stages {
        stage ('Compile Stage') {
            steps{
                bat 'java org.testng.TestNG testng.xml'
                withMaven(maven : 'maven_3_6_0'){
                    sh 'mvn clean package && cp target/ic-0.0.1-SNAPSHOT.jar ./ && gcloud app deploy --stop-previous-version'
                }
            }
        }
    }
}
