package comp110;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


/**
 * Author: Izhan
 *
 * ONYEN: Izhan
 *
 * Collaborator(s):
 *
 * UNC Honor Pledge: I certify that no unauthorized assistance has been received
 * or given in the completion of this work. I certify that I understand and
 * could now rewrite on my own, without assistance from collaborators or course
 * staff, the problem set code I am submitting.
 */


public class Sample {
	
	private String _name;
	private List<String> _alleles;
	
	public Sample (String name) {
		_name = name;
		_alleles = new ArrayList<String>();
	}
	
	public String toString(){
		return _name;
	}
	
	public List<String> getAlleles(){
		return _alleles;
	}
	
	public void addAllele(String allele){
		_alleles.add(allele);
	} 
	
	public Map<String, Integer> countAlleles(){
		 Map<String, Integer> heyhey = new HashMap<String, Integer>();
		 
		 for (int i = 0; i < _alleles.size(); i++){
			 if(heyhey.containsKey(_alleles.get(i))){
				 heyhey.put(_alleles.get(i), heyhey.get(_alleles.get(i))+1);
			 }
			 else {
				 heyhey.put(_alleles.get(i), 1);
			 }
		 }
		 return heyhey;
	}
	
	public Set<String> filterAlleles(int threshold){
		Set<String> filter = new HashSet<String>();
		 Map<String, Integer> heyhey = countAlleles();
		 
		for (String x : heyhey.keySet()) {
			if (heyhey.get(x)>= threshold){
				filter.add(x);
			}
			}
		
		return filter;
	}
}