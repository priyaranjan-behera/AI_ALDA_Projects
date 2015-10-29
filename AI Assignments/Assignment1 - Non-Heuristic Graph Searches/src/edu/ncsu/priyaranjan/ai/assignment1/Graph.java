package edu.ncsu.priyaranjan.ai.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph {

	Integer adjMat[][] = new Integer[20][20];
	
	String nodeNames[] = new String[20];
	
	Integer rootNode = new Integer(14);
	
	public List<Integer> getChildNodes(Integer parent)
	{
		List<Integer> childNodes = new ArrayList<Integer>();
		
		for(int i=0; i<adjMat.length; i++)
		{
			if (adjMat[parent][i].equals(new Integer(1)))
			{
				childNodes.add(new Integer(i));
			}
		}
		
		Collections.sort(childNodes);
		
		return childNodes;
		
	}
	
	public String getNodeName(Integer nodeId)
	{
		return nodeNames[nodeId];
	}

	public Graph() {
	    
		for (int i=0; i<adjMat.length; i++)
			for (int j=0; j<adjMat.length; j++)
				adjMat[i][j] = 0;
		
	    adjMat[12][19]=1;
	    adjMat[19][0]=1;
	    adjMat[0][16]=1;
	    adjMat[16][9]=1;
	    adjMat[9][10]=1;
	    adjMat[3][10]=1;
	    adjMat[12][15]=1;
	    adjMat[0][15]=1;
	    adjMat[3][2]=1;
	    adjMat[15][14]=1;
	    adjMat[15][5]=1;
	    adjMat[14][2]=1;
	    adjMat[13][2]=1;
	    adjMat[14][13]=1;
	    adjMat[1][13]=1;
	    adjMat[1][5]=1;
	    adjMat[1][6]=1;
	    adjMat[1][17]=1;	
	    adjMat[18][17]=1;
	    adjMat[7][17]=1;
	    adjMat[7][4]=1;
	    adjMat[18][8]=1;
	    adjMat[11][8]=1;
	    
	    adjMat[19][12] = 1;
	    adjMat[0][19] = 1;
	    adjMat[16][0] = 1;
	    adjMat[9][16] = 1;
	    adjMat[10][9] = 1;
	    adjMat[10][3] = 1;
	    adjMat[15][12] = 1;
	    adjMat[15][0] = 1;
	    adjMat[2][3] = 1;
	    adjMat[14][15] = 1;
	    adjMat[5][15] = 1;
	    adjMat[2][14] = 1;
	    adjMat[2][13] = 1;
	    adjMat[13][14] = 1;
	    adjMat[13][1] = 1;
	    adjMat[5][1] = 1;
	    adjMat[6][1] = 1;
	    adjMat[17][1] = 1;
	    adjMat[17][18] = 1;
	    adjMat[17][7] = 1;
	    adjMat[4][7] = 1;
	    adjMat[8][18] = 1;
	    adjMat[8][11] = 1;

	    nodeNames[0]="arad";
	    nodeNames[1]="bucharest";
	    nodeNames[2]="craiova";
	    nodeNames[3]="dobreta";
	    nodeNames[4]="eforie";
	    nodeNames[5]="fagaras";
	    nodeNames[6]="giurgiu";
	    nodeNames[7]="hirsova";
	    nodeNames[8]="iasi";
	    nodeNames[9]="lugoj";
	    nodeNames[10]="mehadia";
	    nodeNames[11]="neamt";
	    nodeNames[12]="oradea";
	    nodeNames[13]="pitesti";
	    nodeNames[14]="rimnicu_vilcea";
	    nodeNames[15]="sibiu";
	    nodeNames[16]="timisoara";
	    nodeNames[17]="urziceni";
	    nodeNames[18]="vaslui";
	    nodeNames[19]="zerind";


	}

	public Integer[][] getAdjMat() {
		return adjMat;
	}

	public void setAdjMat(Integer[][] adjMat) {
		this.adjMat = adjMat;
	}

	public Integer getRootNode() {
		return rootNode;
	}

	public void setRootNode(Integer rootNode) {
		this.rootNode = rootNode;
	}

	public String[] getNodeNames() {
		return nodeNames;
	}

	public void setNodeNames(String[] nodeNames) {
		this.nodeNames = nodeNames;
	}
	
	
}
