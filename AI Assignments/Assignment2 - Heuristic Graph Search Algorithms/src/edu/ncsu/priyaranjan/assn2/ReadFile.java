package edu.ncsu.priyaranjan.assn2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ReadFile {
	String cityPath = "C:/Users/Priyaranjan/Desktop/Cities.txt";
	String roadPath = "C:/Users/Priyaranjan/Desktop/Roads.txt";
	FileReader fr;
	BufferedReader textReader;
	HashMap<String, City> cities;
	ArrayList<Road> roads;
	
	public ReadFile(String cityPath, String roadPath) {
		this.cityPath = cityPath;
		this.roadPath = roadPath;
	}
	
	public HashMap<String, City> getCities()
	{
		cities = new HashMap<String, City>();
		try 
		{
			fr = new FileReader(cityPath);

			textReader = new BufferedReader(fr);
		
			String aLine;
		
			while(true)
			{	
				aLine = textReader.readLine(); 
				if (aLine == null)
				{
					break;
				}
				String delims = "[,]";
				String[] tokens = aLine.split(delims);
				City temp = new City();
				temp.setCityName(tokens[0]);
				temp.setLatitude(Double.parseDouble(tokens[1]));
				temp.setLongitude(Double.parseDouble(tokens[2]));
				
				cities.put(tokens[0], temp);
				
			}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return cities;
	}
	
	
	public ArrayList<Road> getRoads()
	{
		roads = new ArrayList<Road>();
		try 
		{
			fr = new FileReader(roadPath);

			textReader = new BufferedReader(fr);
		
			String aLine;
		
			while(true)
			{	
				aLine = textReader.readLine(); 
				if (aLine == null)
				{
					break;
				}
				String delims = "[,]";
				String[] tokens = aLine.split(delims);
				Road temp = new Road();
				temp.setSource(cities.get(tokens[0]));
				temp.setDestination(cities.get(tokens[1]));
				temp.setDistance(Double.parseDouble((tokens[2])));
				
				roads.add(temp);
				
			}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return roads;
	}
	

}
