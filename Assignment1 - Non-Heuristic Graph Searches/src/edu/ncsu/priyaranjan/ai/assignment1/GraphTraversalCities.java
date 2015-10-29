package edu.ncsu.priyaranjan.ai.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversalCities {
	
	public void BFSTraversal(Graph g, Integer dest, Integer source)
	{
		Queue<Integer> nodesToProcess = new LinkedList<Integer>();
		List<Integer> visitedNodes = new ArrayList<Integer>();
		int length = 0;
		boolean found = false;
		
		System.out.println("");
		System.out.println("************************************************");
		
		System.out.println("Starting From: " + g.getNodeName(source));
		nodesToProcess.add(source);
		
		while(!nodesToProcess.isEmpty())
 		{
			Integer temp = nodesToProcess.peek();
			List<Integer> childNodes;
			if (!visitedNodes.contains(temp))
			{
				childNodes = new ArrayList<Integer>();
				childNodes = g.getChildNodes(temp);
				System.out.println("BFS Traversed Node: " + g.getNodeName(temp));
				
				visitedNodes.add(temp);
				nodesToProcess.remove();
				nodesToProcess.remove(temp);
				if(temp.equals(new Integer(dest)))
				{
					System.out.println("Destination Reached: " + g.getNodeName(temp));
					found = true;
					break;
				}
				length++;
				
				for(Integer childNode: childNodes)
				{
					if (!visitedNodes.contains(childNode))	
					{
						nodesToProcess.add(childNode);
					}
				}
			}
			
		}
		
		if (!found)
			System.out.println("Path doesn't exist!");
		else
			System.out.println("Length of BFS Traversed Graph: " + length);
			
	}
	
	public void DFSTraversal(Graph g, Integer dest, Integer source)
	{
		Stack<Integer> nodesToProcess = new Stack<Integer>();
		List<Integer> visitedNodes = new ArrayList<Integer>();
		int length = 0;
		boolean found = false;
		
		System.out.println("");
		System.out.println("************************************************");
		
		System.out.println("Starting From: " + g.getNodeName(source));
		nodesToProcess.add(source);
		
		while(!nodesToProcess.isEmpty())
 		{
			Integer temp = nodesToProcess.peek();
			List<Integer> childNodes;
			if (!visitedNodes.contains(temp))
			{
				childNodes = new ArrayList<Integer>();
				childNodes = g.getChildNodes(temp);
				Collections.reverse(childNodes);
				System.out.println("DFS Traversed Node: " + g.getNodeName(temp));
				
				visitedNodes.add(temp);
				nodesToProcess.pop();
				nodesToProcess.remove(temp);
				if(temp.equals(new Integer(dest)))
				{
					System.out.println("Destination Reached: " + g.getNodeName(temp));
					found = true;
					break;
				}
					
				length++;
				
				for(Integer childNode: childNodes)
				{
					if (!visitedNodes.contains(childNode))	
					{
						nodesToProcess.push(childNode);
					}
				}
			}
			
		}
		

		if (!found)
			System.out.println("Path doesn't exist!");
		else
			System.out.println("Length of DFS Traversed Graph: " + length);
		
	}
	
	public void BFSTraversalStack(Graph g, Integer dest, Integer source)
	{
		Queue<Integer> nodesToProcess = new LinkedList<Integer>();
		List<Integer> visitedNodes = new ArrayList<Integer>();
		Iterator<Integer> iterator;
		int length = 0;
		boolean found = false;
		
		System.out.println("");
		System.out.println("************************************************");
		
		System.out.println("Starting From: " + g.getNodeName(source));
		nodesToProcess.add(source);
		
		while(!nodesToProcess.isEmpty())
 		{
			Integer temp = nodesToProcess.peek();
			List<Integer> childNodes;
			if (!visitedNodes.contains(temp))
			{
				childNodes = new ArrayList<Integer>();
				childNodes = g.getChildNodes(temp);
				System.out.println("BFS Traversed Node: " + g.getNodeName(temp));
				
				visitedNodes.add(temp);
				nodesToProcess.remove();
				nodesToProcess.remove(temp);
				if(temp.equals(new Integer(dest)))
				{
					System.out.println("Destination Reached: " + g.getNodeName(temp));
					found = true;
					break;
				}
				length++;
				
				for(Integer childNode: childNodes)
				{
					if (!visitedNodes.contains(childNode))	
					{
						nodesToProcess.add(childNode);
					}
				}
			}
			
			iterator = nodesToProcess.iterator();
			
			System.out.println("");
			System.out.println("The Stack after iteration is: ");
			while(iterator.hasNext())
				System.out.print(g.getNodeName(iterator.next()) + " ");
			
		}
		
		
		
		if (!found)
			System.out.println("Path doesn't exist!");
		else
			System.out.println("Length of BFS Traversed Graph: " + length);
			
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		GraphTraversalCities gT = new GraphTraversalCities();
		
		System.out.println("Q3(a) The Traversal from Zerind to Craiova and back by BFS:");
		gT.BFSTraversal(g, new Integer(2), new Integer(19));
		gT.BFSTraversal(g, new Integer(19), new Integer(2));
		
		
		System.out.println("");
		System.out.println("Q3(a) The Traversal from Zerind to Craiova and back by DFS:");
		gT.DFSTraversal(g, new Integer(2), new Integer(19));
		gT.DFSTraversal(g, new Integer(19), new Integer(2));
		

		System.out.println("");
		System.out.println("Q3(b) Depth First Performs Worse (Craiova to Pitesti):");
		
		gT.BFSTraversal(g, new Integer(13), new Integer(2));
		gT.DFSTraversal(g, new Integer(13), new Integer(2));
		

		System.out.println("");
		System.out.println("Q3(c) Breadth First Performs Worse (Craiova to Timisoara):");
		gT.BFSTraversal(g, new Integer(16), new Integer(2));
		gT.DFSTraversal(g, new Integer(16), new Integer(2));


	}

}
