package edu.ncsu.priyaranjan.assn2;

/*In java:

java SearchUSA searchtype srccityname destcityname

The searchtype should be either astar, greedy, or uniform.

This program necessitates the use of files Cities.txt and Roads.txt to execute the search.

Standard libraries of Java has been used for the codes and technical issues were resolved using queries at StackOverflow.
*/

import java.util.ArrayList;
import java.util.PriorityQueue;



public class SearchUSA {

	Graph graph = new Graph();
	public void traverse(String source, String destination, String searchType)
	{
		//City sourceCity = graph.getCities().get(source);
		//City destinationCity = graph.getCities().get(destination);
		
		System.out.println("************************************************************");
		System.out.println(searchType + " Traversal");
		System.out.println("Source City : " + source);
		System.out.println("Destination City : " + destination);
		

		PriorityComparator pq = new PriorityComparator();

		ArrayList<String> initialPath = new ArrayList<String>();
		initialPath.add(source);
		StackEntry initialStackEntry = new StackEntry();
		initialStackEntry.setPath(initialPath);
		PriorityQueue<StackEntry> queue= new PriorityQueue<StackEntry>(11,pq);
		queue.add(initialStackEntry);

		StackEntry topPath;
		StackEntry childPath;

		ArrayList<String> childNodes;
		ArrayList<String> visitedNodes = new ArrayList<String>();
		boolean found = false;

		visitedNodes.add(source);
		while(!queue.isEmpty())
		{
			topPath = queue.remove();
			String topCity = topPath.getPath().get(topPath.getPath().size()-1);
			if(topCity.equals(destination))
			{
				System.out.println("Destination Found!");
				found = true;
				System.out.println("The Total Number of Expanded Nodes: " + visitedNodes.size());
				for(int j=0; j<visitedNodes.size(); j++)
				{
					System.out.print(visitedNodes.get(j) + " , ");
				}
				System.out.println("");
				System.out.println("The Total Number of Nodes in Solution Path: " + topPath.getPath().size());
				System.out.println("The Solution Path is: ");
				for(int i=0; i < topPath.getPath().size(); i++)
				{
					System.out.print(topPath.getPath().get(i) + " , ");
				}
				System.out.println("");
				System.out.println("Cost of the Path: " + topPath.getCostToNode());
				break;
			}

			childNodes = graph.getChildNodes(topCity);

			for(String child:childNodes)
			{
				if(visitedNodes.contains(child))
					continue;
				childPath = new StackEntry(topPath);
				childPath.getPath().add(child);
				childPath.setCostToNode(childPath.getCostToNode() + graph.getCost(topCity, child));
				childPath.setPriority(getCostFunction(childPath, destination, searchType));
				queue.add(childPath);
				visitedNodes.add(child);
			}




		}
		if (found==false)
		{
			System.out.println("Path doesn't exist!");
		}


	}


	public double getCostFunction(StackEntry stackEntry, String destination, String searchType)
	{
		Double costFunction = new Double(0);
		ArrayList<String> stackPath= stackEntry.getPath();
		City currentCity = graph.getCities().get(stackPath.get(stackPath.size()-1));
		City destinationCity = graph.getCities().get(destination);

		
		if(searchType.equals("greedy")) {
			//costFunction = Math.sqrt(Math.pow(69.5 * (destinationCity.getLatitude() - currentCity.getLatitude()), 2) + (69.5 * Math.cos(((currentCity.getLatitude()+destinationCity.getLatitude())/360)*Math.PI) * Math.pow(currentCity.getLongitude()-destinationCity.getLongitude(), 2)));
			costFunction = Math.sqrt(Math.pow(69.5 * (destinationCity.getLatitude() - currentCity.getLatitude()), 2) + Math.pow((69.5 * Math.cos(((currentCity.getLatitude()+destinationCity.getLatitude())/360)*Math.PI) * (currentCity.getLongitude()-destinationCity.getLongitude())), 2));
		} else if(searchType.equals("astar")) {
			costFunction = stackEntry.costToNode + Math.sqrt(Math.pow(69.5 * (destinationCity.getLatitude() - currentCity.getLatitude()), 2) + Math.pow((69.5 * Math.cos(((currentCity.getLatitude()+destinationCity.getLatitude())/360)*Math.PI) * (currentCity.getLongitude()-destinationCity.getLongitude())), 2));
		} else if(searchType.equals("uniform")) {
			costFunction = stackEntry.costToNode;
		} else {
			costFunction = new Double(0);
		}
			
				
		return costFunction;
	}
	
	public static void main(String[] args)
	{
		SearchUSA sUSA = new SearchUSA();
		ArrayList<Road> roads = sUSA.graph.getRoads();
		
		//sUSA.traverse("losAngeles", "portland", "uniform");
		if(args.length < 3)
		{
			System.out.println("Invalid Invocation - SearchUSA <searchMethod> <Source City> <Destination City>");
			return;
		}
		if (!sUSA.graph.getCities().containsKey(args[1]))
		{
			System.out.println("Invalid Source City");
			return;
		}
		if (!sUSA.graph.getCities().containsKey(args[2]))
		{
			System.out.println("Invalid Destination City");
			return;
		}
		if(!args[0].equals("greedy")&&!args[0].equals("astar")&&!args[0].equals("uniform"))
		{
			System.out.println("Invalid Search Method");
			return;
		}
		sUSA.traverse(args[1], args[2], args[0]);
		
		//Investigative Code Starts
		/*
		sUSA.traverse(args[1], args[2], "greedy");
		sUSA.traverse(args[1], args[2], "greedy");
		sUSA.traverse(args[1], args[2], "astar");
		sUSA.traverse(args[2], args[1], "astar");
		sUSA.traverse(args[1], args[2], "uniform");
		sUSA.traverse(args[2], args[1], "uniform");
		*/
		
	}
}
