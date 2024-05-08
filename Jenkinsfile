pipeline{
  agent any
  stages{
    stage("Start"){
      steps{
        echo "starting jenkins"
      }
    }
  }

  stages{
    stage("Build Image"){
      steps {
        sh "./Project/Ecommerce/build.sh"
      }
    }
  }
}