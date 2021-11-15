package com.dasees.problems;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class ShibuyaCrossingProblem {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int personcount=input.nextInt();
		int crossedpathcount=input.nextInt();

			Set<Integer>[] totalperson = new Set[personcount] ;
			
			for (int i=0;i<personcount;i++) {
		          
				totalperson[i]= new TreeSet<Integer>();
							
		        }
			for (int i=0;i<crossedpathcount;i++) {
				
				int a=input.nextInt()-1;
				int b=input.nextInt()-1;
				
				totalperson[a].add(b);
				
			}
			List<Integer> ordersorting = new ArrayList<Integer>();
			List<ArrayList<Integer>> listoflistofallpersons = new ArrayList<ArrayList<Integer>>();
			for (int i=0;i<personcount;i++) {
				ArrayList<Integer> listofallpersons =new ArrayList<Integer>();
				
				for(int k=0;k<i;k++)
				{
					if(totalperson[k].contains(i)) {
						
						listofallpersons.add(k);
					}
				}
							
				listoflistofallpersons.add(listofallpersons);
				
				if(!listofallpersons.isEmpty())
				{
					int value=crossedpathcount;
					for(int t=0;t<listofallpersons.size();t++)
						{
						 int reference=ordersorting.indexOf(listofallpersons.get(t));
						 if(reference<value)
						 {
							 value=reference;
						 }
						}
					ordersorting.add(value,i);
				}
				else
				{
					ordersorting.add(i);
				}
						
			input.close();
			
		}
			
			
			int size=ordersorting.size();
			int[] temparray=new int[size];
			temparray[0] = 1;
			

			for (int i = 1; i < temparray.length; i++) {
				int tempvalue=0;
				for (int j = 0; j < i; j++) {
					if (ordersorting.get(j) > ordersorting.get(i) && temparray[j] > tempvalue) {
						tempvalue = temparray[j];
					}
				}
				temparray[i] = tempvalue + 1;
				
			}

		       
		         int maxvalue = temparray[0];		       
		         for (int i = 1; i < temparray.length; i++)
		             if (temparray[i] > maxvalue)
		                 maxvalue = temparray[i];
		        
		         System.out.println(maxvalue);
		    
	 			         
			
	}	
		
}
	
