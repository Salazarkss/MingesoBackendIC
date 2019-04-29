pipeline {
    agent any

    stages {
        stage ('Compile Stage') {
            steps{
                withMaven(maven : 'maven_3_6_0'){
                    sh 'mvn clean install && mv target/ic-0.0.1-SNAPSHOT.jar ./ && gcloud app deploy'
                }
            }
        }
    }
}
