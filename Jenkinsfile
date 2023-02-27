pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                timeout(time: 1, unit: 'MINUTES') {
                  sh './gradlew clean'
                }
                timeout(time: 5, unit: 'MINUTES') {
                  sh './gradlew build'
                  junit '**/build/*.xml'
                }
            }
        }
    }
}
