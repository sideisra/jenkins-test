def printHello() {
    println "Hello World!"
}

pipeline {
    agent any

    stages {
        stage('Clean') {
            steps {
                timeout(time: 1, unit: 'MINUTES') {
                  sh './gradlew clean'
                  script {
                    printHello()
                  }
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
        stage('Assemble') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                  sh './gradlew assemble'
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
                    jacoco(minimumInstructionCoverage: '100',changeBuildStatus: true)
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
    post {
        always {
            chuckNorris()
        }
    }
}
