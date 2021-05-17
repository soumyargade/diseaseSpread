import java.io.*;
import java.util.*;

public class Infection {
	public static void main(String[] args) throws IOException {
		BufferedReader scanner = new BufferedReader(new FileReader(args[0]));
		Infection programme = new Infection();
		// arraylist to represent everyone in the population
		ArrayList<Individual> individuals = new ArrayList<Individual>();
		// create list of individuals in the population
		individuals = programme.start(scanner);
		// remove the last val in the list, which is an empty line
		int index = individuals.size() - 1;
		individuals.remove(index);
		// assign friend relationships to the individuals
		individuals = programme.middle(scanner, individuals);
		// set the various params from user input
		int initialInfected = Integer.parseInt(args[1]);
		double baseRate = Double.parseDouble(args[2]);
		int maxSteps = Integer.parseInt(args[3]);
		// arraylist to keep track of infected people
		ArrayList<Individual> infected = new ArrayList<Individual>();
		// arraylist to keep track of the names of infected people
			// this is necessary to avoid duplicates
		ArrayList<String> namesOfTheInfected = new ArrayList<String>();

		// set_random_infection(InitialInfected)
		int counter = 0;
		while (counter < initialInfected) {
			// randomly infect individuals in the population
			Random rand = new Random();
			int upperbound = individuals.size();
			int int_random = rand.nextInt(upperbound);
			individuals.get(int_random).infectionStatus = true;
			// adding individual to the infected people
			infected.add(individuals.get(int_random));
			namesOfTheInfected.add(individuals.get(int_random).name);
			counter += 1;
		}
		
		// setting the correct number of people who were infected
			// sometimes the call to random above will invoke
			// the index of a person who was already infected
		int steps = 0;
		int numInfected = 0;
		for (Individual person : individuals) {
			if (person.infectionStatus == true) {
				numInfected += 1;
			}
		}
		// calculating the infection rate
		double infectionRate = (numInfected * 1.0) / individuals.size();
		// initial step begins from 0
		int stepCount = 0;
		// formatting the output as in the instructions
		System.out.println(stepCount + ", " + numInfected + ", " + individuals.size());
		// while (Infection Rate < 1) and steps < max_steps
		while (infectionRate < 1.0 && steps < maxSteps) {
			for (Individual person : individuals) {
				// for H in Healthy_Persons:
				if (!infected.contains(person)) {
					// for I in infected neighbors of H
					for (Edge neighbor : person.adjacencies) {
						if (neighbor.friend.infectionStatus == true) {
							// if infection passes p(H, I)
							double probInfectionPasses = baseRate*neighbor.weight;
							double randomNum = Math.random();
							if (randomNum < probInfectionPasses) {
								// H.set_infection(True)
								if (!namesOfTheInfected.contains(person.name)) {
									person.infectionStatus = true;
									numInfected += 1;
									infected.add(person);
									namesOfTheInfected.add(person.name);
								}
							}
						}
					}
				}
			}
			steps += 1;
			stepCount += 1;
			infectionRate = (numInfected * 1.0) / individuals.size();
			System.out.println(stepCount + ", " + numInfected + ", " + individuals.size());
		}
	}

	// create list of individuals in the population
	public ArrayList<Individual> start(BufferedReader scanner) throws IOException {
		String line = scanner.readLine(); // skip the first line
		ArrayList<Individual> individuals = new ArrayList<Individual>();
		while (!line.isEmpty()) {
			line = scanner.readLine();
			individuals.add(new Individual(line, false));
		}
		return individuals;
	}

	// assign friend relationships to the individuals
	public ArrayList<Individual> middle(BufferedReader scanner, ArrayList<Individual> individuals) throws IOException {
		String line = scanner.readLine();
		while ((line = scanner.readLine()) != null) {
			String[] tokens = line.split("\\s+");
			String tokenStr = Arrays.toString(tokens);
			tokenStr = tokenStr.replaceAll(",", "");
			tokenStr = tokenStr.replace("[", "");
			tokenStr = tokenStr.replace("]", "");
			Object[] dummy = new Object[3];
			int i = 0;
			for (String s : tokenStr.split(" ")) {
				dummy[i] = s;
				i += 1;
			}
			for (Individual person : individuals) {
				Individual target = null;
				if (person.name.equals(dummy[1])) {
					for (Individual targetPerson : individuals) {
						if (targetPerson.name.equals(dummy[0])) {
							target = targetPerson;
							double cost = Double.parseDouble((String)dummy[2]);
							person.adjacencies.add(new Edge(target, cost));
						}
					}
				}
				if (person.name.equals(dummy[0])) {
					for (Individual targetPerson : individuals) {
						if (targetPerson.name.equals(dummy[1])) {
							target = targetPerson;
							double cost = Double.parseDouble((String)dummy[2]);
							person.adjacencies.add(new Edge(target, cost));
						}
					}
				}
			}
		}
		return individuals;
	}
}