package edu.ncsu.priyaranjan.assn2;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
	
	HashMap<String, City> cities;
	ArrayList<Road> roads;
	
	public Graph()
	{
		ReadFile readFile = new ReadFile("C:/Users/Priyaranjan/Desktop/Cities.txt", "C:/Users/Priyaranjan/Desktop/Roads.txt");
		cities = readFile.getCities();
		roads = readFile.getRoads();
	}

	public ArrayList<String> getChildNodes(String parentCity)
	{
		ArrayList<String> childNodes = new ArrayList<String>();
		for(Road temp:roads)
		{
			//System.out.println("Checking Road To " + temp.getDestination().getCityName());
			//System.out.println("Checking Road From " + temp.getSource().getCityName());
			
			if(temp.getSource().getCityName().equals(parentCity))
			{
				childNodes.add(temp.getDestination().getCityName());
			}
			else if(temp.getDestination().getCityName().equals(parentCity))
			{
				childNodes.add(temp.getSource().getCityName());
			}
		}
		
		return childNodes;
		
	}
	
	public Double getCost(String sourceCity, String destinationCity)
	{
		for(Road temp:roads)
		{
			if(temp.getSource().getCityName().equals(sourceCity) && temp.getDestination().getCityName().equals(destinationCity))
			{
				return new Double(temp.getDistance().intValue());
			}
			else if(temp.getSource().getCityName().equals(destinationCity) && temp.getDestination().getCityName().equals(sourceCity))
			{
				return new Double(temp.getDistance().intValue());
			}
		}
		
		return new Double(99999);
		
	}

	public HashMap<String, City> getCities() {
		return cities;
	}

	public void setCities(HashMap<String, City> cities) {
		this.cities = cities;
	}

	public ArrayList<Road> getRoads() {
		return roads;
	}

	public void setRoads(ArrayList<Road> roads) {
		this.roads = roads;
	}
}
