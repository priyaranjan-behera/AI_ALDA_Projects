package edu.ncsu.priyaranjan.assn2;

import java.util.Comparator;

public class PriorityComparator implements Comparator<StackEntry> {

	@Override
	public int compare(StackEntry arg0, StackEntry arg1) {
		Double result = arg0.priority - arg1.priority;
		return result.intValue();
	}

}
