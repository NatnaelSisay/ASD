pipeline{
  agent any
  stages{
    stage("Start"){
      steps{
        echo "starting jenkins"
      }
    }
  }

  stages("Build Image"){
    steps {
      sh "./Project/Ecommerce/build.sh"
    }
  }
}