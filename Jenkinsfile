pipeline {
  agent any
  tools {
      jdk 'jdk8'
      maven 'mvn'
  }
  stages {
      stage('Install') {
          steps {
              sh "mvn clean install"
              sh "mvn -U clean test cobertura:cobertura -Dcobertura.report.format=xml"
          }
          post {
              always {
                  junit '**/target/*-reports/TEST-*.xml'
                  step([$class: 'CoberturaPublisher', coberturaReportFile: 'target/site/cobertura/coverage.xml'])
              }
          }
       }
       
        
 
    }
}
