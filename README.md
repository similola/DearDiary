# Dear Diary

A java program that uses Microsoft cognitive services speech to text to transcribe diary entries.

## Prerequisites

Create speech resource on Azure portal

## Build locally
First run this maven command to clean, build, run tests and package the project
```
mvn package
```
Run using this java command from the command line
```
java -cp target/* com.deardiary.Main [subscriptionkey] [serviceregion]
```
## CI/CD using Azure and Github actions

I set up continuous integration and deployment for this project.

1. Create an Azure Web app
2. Use a Service Principal by running this in CLI and use result JSON as Github secret

```
 az ad sp create-for-rbac --name "myApp" --role contributor \
                          --scopes /subscriptions/{subscription-id}/resourceGroups/{resource-group}/providers/Microsoft.Web/sites/{app-name} \
                          --sdk-auth
```

3.Setup .yml file in Github actions to define workflow for building project and deploying to Azure (See comments in .yml file below for each step)
```
on: [push,pull_request]

jobs:
  build-and-deploy:
    runs-on: ubuntu-latest
    steps:

    # checkout the repo
    - name: 'Checkout Github Action' 
      uses: actions/checkout@master
    
    #Login to Azure
    - name: 'Login via Azure CLI'
      uses: azure/login@v1
      with:
        creds: ${{ secrets.AZURE_CREDENTIALS }}
    
    # Maven Build and package
    - name: Set up JDK 1.8
      uses: actions/setup-java@v1
      with:
        java-version: 1.8
    - name: Build with Maven
      run: mvn package --file pom.xml

   # deploy web app using publish profile credentials
    - uses: azure/webapps-deploy@v1
      with: 
        app-name: deardiary  # Replace with your app name
        package: '${{ github.workspace }}/target/*.jar'
    
    #Logout of Azure
    - name: Azure logout
      run: |
        az logout
```
4.Now on every push and pull requests, my project builds and deploys :)

## To do list

Instructions for running deployed java app