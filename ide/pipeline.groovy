<?xml version='1.1' encoding='UTF-8'?>
<flow-definition plugin="workflow-job@1207.ve6191ff089f8">
  <actions>
    <org.jenkinsci.plugins.pipeline.modeldefinition.actions.DeclarativeJobAction plugin="pipeline-model-definition@2.2114.v2654ca_721309"/>
    <org.jenkinsci.plugins.pipeline.modeldefinition.actions.DeclarativeJobPropertyTrackerAction plugin="pipeline-model-definition@2.2114.v2654ca_721309">
      <jobProperties/>
      <triggers/>
      <parameters/>
      <options/>
    </org.jenkinsci.plugins.pipeline.modeldefinition.actions.DeclarativeJobPropertyTrackerAction>
  </actions>
  <description></description>
  <keepDependencies>false</keepDependencies>
  <properties/>
  <definition class="org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition" plugin="workflow-cps@2759.v87459c4eea_ca_">
    <script>pipeline {
    agent any

    stages {
        stage(&apos;checkout&apos;) {
            steps {
                
                git branch: &apos;main&apos;, url: &apos;https://github.com/RGillR/jgsu-spring-petclinic&apos;

            }
        }    
        stage(&apos;build&apos;)    {
            steps {
                sh &apos;./mvnw clean package&apos;
                
        }

            

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
               always {
                   junit &apos;**/target/surefire-reports/TEST-*.xml&apos;
                   archiveArtifacts &apos;target/*.jar&apos;
                   }
            }
        }
    }
    
}

</script>
    <sandbox>true</sandbox>
  </definition>
  <triggers/>
  <disabled>false</disabled>
</flow-definition>