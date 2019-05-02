pipeline {
    agent any

    stages {
        stage ('Compile Stage') {
            steps{
                withMaven(maven : 'maven_3_6_0'){
                    sh 'mvn clean package && cp target/ic-0.0.1-SNAPSHOT.jar ./'
                }
            }
        }
        stage ('Tests') {
            steps{
                sh 'java -jar org.testng.TestNG testng.xml'
            }
        }
        stage ('Deploy') {
            steps{
                sh 'gcloud app deploy --stop-previous-version'
            }
        }
    }
}
