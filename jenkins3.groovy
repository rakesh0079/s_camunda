pipeline {
    tools {
    maven 'maven-3.8.6' 
  }
    agent any
    stages {
stage('Ready for Build'){
steps{
echo 'Read for Build'
}

}
stage('Build Application'){
steps{
    sh 'mvn clean package'
}


post {
success {
    echo 'Archive artifact ..'
    archiveArtifacts artifacts: '**/*.war'

}
}


}
  }
}
