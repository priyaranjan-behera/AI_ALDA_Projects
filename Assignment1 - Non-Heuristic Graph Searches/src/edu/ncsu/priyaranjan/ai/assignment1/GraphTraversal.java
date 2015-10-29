package edu.ncsu.priyaranjan.ai.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversal {
	
	public void BFSTraversal(Graph g, Integer dest)
	{
		Queue<Integer> nodesToProcess = new LinkedList<Integer>();
		List<Integer> visitedNodes = new ArrayList<Integer>();
		int length = 0;
		
		nodesToProcess.add(g.getRootNode());
		
		while(!nodesToProcess.isEmpty())
 		{
			Integer temp = nodesToProcess.peek();
			List<Integer> childNodes;
			if (!visitedNodes.contains(temp))
			{
				childNodes = new ArrayList<Integer>();
				childNodes = g.getChildNodes(temp);
				System.out.println("BFS Traversed Node: " + temp.toString());
				
				visitedNodes.add(temp);
				nodesToProcess.remove();
				nodesToProcess.remove(temp);
				if(temp.equals(new Integer(dest)))
					break;
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
		
		System.out.println("Length of BFS Traversed Graph: " + length);
		
		
		
	}
	
	public void DFSTraversal(Graph g, Integer dest)
	{
		Stack<Integer> nodesToProcess = new Stack<Integer>();
		List<Integer> visitedNodes = new ArrayList<Integer>();
		int length = 0;
		
		nodesToProcess.add(g.getRootNode());
		
		while(!nodesToProcess.isEmpty())
 		{
			Integer temp = nodesToProcess.peek();
			List<Integer> childNodes;
			if (!visitedNodes.contains(temp))
			{
				childNodes = new ArrayList<Integer>();
				childNodes = g.getChildNodes(temp);
				Collections.reverse(childNodes);
				System.out.println("DFS Traversed Node: " + temp.toString());
				
				visitedNodes.add(temp);
				nodesToProcess.pop();
				nodesToProcess.remove(temp);
				if(temp.equals(new Integer(dest)))
					break;
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
		

		System.out.println("Length of DFS Traversed Graph: " + length);
		
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		GraphTraversal gT = new GraphTraversal();
		gT.BFSTraversal(g, new Integer(0));
		gT.DFSTraversal(g, new Integer(0));

	}

}
