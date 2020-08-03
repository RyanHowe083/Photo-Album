# Photo-Album
Console application that displays photo ids and titles in an album. The photos are available in this online web service (https://jsonplaceholder.typicode.com/photos).

TO BUILD
Make sure to have MAVEN installed
  In terminal change directory to Photo-Album/maven-album/
  run mvn clean
  run mvn package
 
 To Run
  In the same directory in terminal enter java -jar target/maven-album-0.0.1-SNAPSHOT.jar
  
  The console will ask which album (1-100) to display (Note if a number is used that does not exist in the list it will not display
album info but instead a warning message).
