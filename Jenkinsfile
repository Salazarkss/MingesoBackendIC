pipeline {
    agent any

    stages {
        stage ('Compile Stage') {
            steps{
                withMaven(maven : 'maven_3_6_0'){
                    sh 'mvn clean package && gcloud app deploy --log-http --verbosity=debug'
                }
            }
        }
    }
}
