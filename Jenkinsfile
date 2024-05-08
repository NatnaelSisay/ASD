pipeline{
  agent {
    node {
        label 'docker-maven'
        customWorkspace '/home/jenkins/agent'    
    }
  }
  stages{
    stage("Start"){
      steps{
        echo "starting jenkins"
      }
    }

    stage("Maven Version"){
            steps {
                sh "mvn --version"
            }
        }
        
    stage("Docker Version"){
        steps {
            sh "docker --version"
        }
    }

    stage("Build Image"){
      steps {
        sh "cd ./Project/Ecommerce && ./build.sh"
      }
    }
  }
}