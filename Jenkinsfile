node {
	agent any
	stages {
		stage('SMC checkout') {
		 git 'https://github.com/asdfghjkln1/MingesoBackendIC'
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
		stage('Deployement Stage'){
			steps {
				withMaven(maven : 'maven_3_6_1') {
					sh 'mvn deploy'
				}
			}
		}
	}
}
