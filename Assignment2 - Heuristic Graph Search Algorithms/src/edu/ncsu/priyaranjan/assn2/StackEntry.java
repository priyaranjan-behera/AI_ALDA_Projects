package edu.ncsu.priyaranjan.assn2;

import java.util.ArrayList;

public class StackEntry {

	ArrayList<String> path;
	Double priority;
	Double costToNode;
	
	public StackEntry(ArrayList<String> path, Double priority, Double costToNode)
	{
		this.path = new ArrayList<String>(path);
		this.priority = new Double(priority);
		this.costToNode = new Double(costToNode);
	}
	
	public StackEntry(StackEntry original)
	{
		this.path = new ArrayList<String>(original.path);
		this.priority = new Double(original.priority);
		this.costToNode = new Double(original.costToNode);
	}
	
	public StackEntry()
	{
		path = new ArrayList<String>();
		priority = new Double(0);
		costToNode = new Double(0);
	}
	
	public ArrayList<String> getPath() {
		return path;
	}
	public void setPath(ArrayList<String> path) {
		this.path = path;
	}
	public Double getPriority() {
		return priority;
	}
	public void setPriority(Double priority) {
		this.priority = priority;
	}
	public Double getCostToNode() {
		return costToNode;
	}
	public void setCostToNode(Double costToNode) {
		this.costToNode = costToNode;
	}
	
	
}
