Maze Solver

This application will take a ASCII maze given as follows

* `.` represents an open road
* `#` represents a blocked road
* `A` represents the starting point
* `B` represents the destination point

and find the shortest path from A to B

To run this application locally you must create a file called 

`dev.properties`

that contains one line that tells the application where your tomcat directory is

An example is

`deployDir = /home/jphamlett/Downloads/apache-tomcat-8.5.15/`

After the file is created run 
`gradle devDeploy`

from a terminal and that's it

Technologies used
* Java 8
* Apache Tomcat
* Gradle
* Junit
* Others that I might not include here
