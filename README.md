# Disease Spread
### How It Works
* Tasked with taking the social network graph in **Assign8Data.txt** and implementing a disease spread model.
* Assign8Data.txt is a graph file which includes edge weights.
* The program also takes an initial infection rate, base infection rate, and maximum number of steps as input.
* InitialInfected and MaxSteps are integers. BaseRate is a floating point number between 0 and 1.
* The program randomly infects the initial number of participants and then iterates until either the maximum step count is reached or all members of the population have become infected. On each iteration, the odds of a healthy individual being infected by a peer is the base rate multiplied by their connection strength.
* On each iteration, the current time step and infection rate are printed as such: *Step, Infected, Total Population*.
### Compile Instructions
    javac Edge.java
    
    javac Individual.java
    
    javac Infection.java
    
    jar cmf Infection.mf Infection.jar Infection.class Individual.class Edge.class
    
    java -jar Infection.jar <Input> <InitialInfected> <BaseRate> <MaxSteps>
### Observations
* If I change the initial infection from a single individual to 10, the disease spreads much more rapidly. To take an example, when I set the initial infection to 1 person and ran the command "java Infection Assign8Data.txt 1 0.6 10", after 10 steps only 27 of the 43 individuals in the population had been infected. However, when I changed the initial infection size to 10 people and ran the command "java Infection Assign8Data.txt 10 0.6 10", after 10 steps 43 people, or the entirety of the population, had been infected.
* The relative impact of scaling the base infection rate from 0.8 down to something like 0.6 or 0.5 is that the disease spreads less rapidly. To take an example, when I set the base infection rate to 0.8 and run the command "java Infection Assign8Data.txt 5 0.8 10", after only 9 steps the entirety of the population is infected, However, when I change the base infection rate to 0.5 and run the command "java Infection Assign8Data.txt 5 0.5 10", after 10 steps only 26 of the 43 in the population have been infected.
### Depiction of Social Network
![social network](https://github.com/soumyargade/diseaseSpread/blob/main/socialnetwork.png)
