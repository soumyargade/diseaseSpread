# Disease Spread
### How It Works
Insert Here.
### Compile Instructions
    javac Edge.java
    
    javac Individual.java
    
    javac Infection.java
    
    jar cmf Infection.mf Infection.jar Infection.class Individual.class Edge.class
    
    java -jar Infection.jar <Input> <InitialInfected> <BaseRate> <MaxSteps>
