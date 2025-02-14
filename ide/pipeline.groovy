pipeline {
    agent any

    stages {
        stage('checkout') {
            steps {
                
                git branch: 'main', url: 'https://github.com/RGillR/jgsu-spring-petclinic'

            }
        }    
        stage('build')    {
            steps {
                sh './mvnw clean package'
                
        }

            

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
               always {
                   junit '**/target/surefire-reports/TEST-*.xml'
                   archiveArtifacts 'target/*.jar'
                   }
            }
        }
    }
    
}

