pipeline {
    agent any

    stages {
        stage('Clean') {
            steps {
                timeout(time: 1, unit: 'MINUTES') {
                  sh './gradlew clean'
                }
            }
        }
        stage('Build') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                  sh './gradlew build -x test'
                }
            }
        }
        stage('Test') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                  sh './gradlew test'
                }
            }
            post {
                always {
                    junit(testResults: "**/build/test-results/test/*.xml", allowEmptyResults: true)
                    publishCoverage adapters: [jacoco(path: '**/build/reports/jacoco/test/jacocoTestReport.xml')]
                }
            }
        }
        stage('Package') {
            when {
                branch 'main'
            }
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                  sh './gradlew assemble'
                }
            }
        }
    }
}
