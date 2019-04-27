node {
	agent any
	stages {
		stage('SMC checkout') {
		 git 'https://github.com/asdfghjkln1/MingesoBackendIC'
		 mvnHome = tool name: 'maven_3_6_1', type: 'maven'
		}
		stage('Compile Stage') { 
			steps {
				withMaven(maven : 'maven_3_6_1') {
					 if (isUnix()) {
         					sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      					 } else {
         					bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      					}
				}
			}
		}
	}
}
