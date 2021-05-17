# Disease Spread
### How It Works
* Tasked with taking the supplied social network graph in **Assign8Data.txt** and implementing a disease spread model.
* Assign8Data.txt is a graph file which includes edge weights.
* The program also takes an initial infection rate, base infection rate, and maximum number of steps as input.
* InitialInfected and MaxSteps are integers. BaseRate is a floating point number between 0 and 1.
* The program randomly infects the initial number of participants and then iterates until either the maximum step count is reached or all members of the population have become infected. On each iteration, the odds of a healthy individual being infected by a peer is the base rate multiplied by their connection strength.
* On each iteration the current time step and infection rate are printed as such: *Step, Infected, Total Population*.
### Compile Instructions
    javac Edge.java
    
    javac Individual.java
    
    javac Infection.java
    
    jar cmf Infection.mf Infection.jar Infection.class Individual.class Edge.class
    
    java -jar Infection.jar <Input> <InitialInfected> <BaseRate> <MaxSteps>
### Observations
Insert Here.
### Depiction of Social Network
![social network](https://github.com/soumyargade/diseaseSpread/blob/main/socialnetwork.png)
