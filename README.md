"# test-task-3" 

App stores data into DB.

To switch app to work with memory storage need uncomment annotation @Service in classes: MessageMemoryServiceImpl,  UserMemoryServiceImpl and comment the same annotation in classes: MessageServiceImpl, UserServiceImpl.

Script for creating DB and insearting some of data is in ./src/db_scripts.

For build app: mvn clean install in directory with pom.xml file.

Builded app is in ./src/target/TestTask3

URL: localhost:8080/TestTask3/
