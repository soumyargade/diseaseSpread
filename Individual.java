import java.io.*;
import java.util.*;

public class Individual {
	String name;
	boolean infectionStatus;
	ArrayList<Edge> adjacencies;

	public Individual(String personName, boolean status) {
		name = personName;
		infectionStatus = status;
		adjacencies = new ArrayList<Edge>();
	}

	@Override
	public String toString() {
		return name;
	}
}