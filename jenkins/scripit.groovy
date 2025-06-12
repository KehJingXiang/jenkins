// All environmental variables and parameters in Jenkinsfile are available in groovy script

def buildApp() {
    echo 'Building the application'
    echo "building version ${NEW_VERSION}"
    //sh "mvn install"
}

def testApp() {
    echo 'Testing the application'
}

def deployApp() {
    echo 'deploying the application'
    echo "deploying version ${params.VERSION}"
    echo "deploying with ${SERVER_CREDENTIALS}"
    // Besides declaring the credentials as environment variable, can acquire in individual stage and store as variable
    withCredentials([
        usernamePassword(credentialsId : 'server-credentials', usernameVariable: 'USER', passwordVariable: 'PWD')
    ]) {
        echo "some script ${USER} ${PWD}"
    }
}

return this