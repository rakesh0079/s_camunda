pipeline {
   tools { 
        maven 'localMaven' 
        jdk 'JDK11' 
    }
    agent any



    stages {

        stage ('Compile Stage') {
steps {

bat'mvn clean compile'

}
}
stage ('Testing Stage') {
steps {

bat'mvn test'

}
}
stage ('Install Stage') {
steps {

bat'mvn install'

}
post {
success {
    echo 'Archieving  rtifact ..'
    archiveArtifacts artifacts: '**/*.war'

}

}
}
  }
}
pipeline {
   tools { 
        maven 'localMaven' 
        jdk 'JDK11' 
    }
    agent any



    stages {

        stage ('Compile Stage') {
steps {

bat'mvn clean compile'

}
}
stage ('Testing Stage') {
steps {

bat'mvn test'

}
}
stage ('Install Stage') {
steps {

bat'mvn install'

}
post {
success {
    echo 'Archieving  rtifact ..'
    archiveArtifacts artifacts: '**/*.war'

}

}
}
stage ('Deployment Stage') {
 echo 'Deployment  Start ..'
 build job: 'StagingDeploymentArtifactPipeline'
}
  
}
}
