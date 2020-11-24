#Run and use app

##Build app:
`mvn clean package`

##Deploy to standalone tomcat:
1. Download Apache Tomcat and unpackage it into a tomcat folder
2. Copy our WAR file from `target/crx_rainyhills.war` to the `tomcat/webapps/` folder
3. From a terminal navigate to `tomcat/bin` folder and execute
    3.1 `catalina.bat` run (on Windows)
    3.2 `catalina.sh` run (on Unix-based systems)
4. Go to `http://localhost:8080/crx_rainyhills/hello` - check app is started, answer is `"hello"`

##Use embedded tomcat:
1. Build project: `mvn clean package`
2. Execute `mvn org.codehaus.cargo:cargo-maven2-plugin:run` in main project folder
3. Go to `http://localhost:8080/crx_rainyhills/hello` - check app is started, answer is `"hello"`

##Execute calculation
Check with `curl`:
Request
`curl -X POST localhost:8080/crx_rainyhills/calculate -H 'Content-type:application/json' -d '{"array": [1, 2, 3]}'`
Response:
`{"waterUnits":0}`

#Base algorithm info

##Algorithm Complexity O(n):

Calculation the highest hills on the left side: O(n)
Calculation volume: O(n)
O(n)+O(n) = O(n)

##Algorithm Memory usage: 
We have 2 arrays: input array, the highest hills on the left side array: 3*(n*4bytes + some overhead) where n is a size of input array Also two int parameters

##About negative integer. 
Example: {0,-2,0} -w- -w- Volume = 2

More cases you can find in the Test class for VolumeCalculator.