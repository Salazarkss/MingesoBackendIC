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
                withMaven(maven : 'maven_3_6_0'){
                    sh 'mvn test -DsuiteXmlFile=testng.xml'
                }
            }
        }
        stage ('Deploy') {
            steps{
                sh 'gcloud app deploy --stop-previous-version'
                sh 'gcloud app versions list | grep -v SERVING | awk '{print $2}' | tail -n +1 | xargs -I {} gcloud app versions delete {}'
            }
        }
    }
}
