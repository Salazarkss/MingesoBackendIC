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
        stage('Deploy'){
            steps{
                sh 'sshpass -e scp target/ic-1.0.0-SNAPSHOT.war root@159.65.3.243:/root'
                sh 'java -jar ic-1.0.0-SNAPSHOT.war'
            }
        }
    }
}
