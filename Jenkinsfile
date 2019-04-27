node {
   def mvnHome
   stage('SCM Chekout') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/asdfghjkln1/MingesoBackendIC.git'   
      mvnHome = tool name: 'maven_3_6_1', type: 'maven'
   }
   stage('Build') {
      // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      } else {
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      }
   }
   stage('Results') {
      // junit '**/target/surefire-reports/TEST-*.xml'
      archiveArtifacts 'target/*.jar'
   }
}
