package lab1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SubsetSum {
	public static <T> Set<Set<T>> powerSet(Set<T> originalSet) {
	    Set<Set<T>> sets = new HashSet<Set<T>>();
	    if (originalSet.isEmpty()) {
	    	sets.add(new HashSet<T>());
	    	return sets;
	    }
	    List<T> list = new ArrayList<T>(originalSet);
	    T head = list.get(0);
	    Set<T> rest = new HashSet<T>(list.subList(1, list.size())); 
	    for (Set<T> set : powerSet(rest)) {
	    	Set<T> newSet = new HashSet<T>();
	    	newSet.add(head);
	    	newSet.addAll(set);
	    	sets.add(newSet);
	    	sets.add(set);
	    }		
	    return sets;
	}
	public static int setsum(Set<Integer> s){
		int sum = 0;
		for(Integer c: s){
			sum += c;
		}
		return sum;
	}
	public static Set subsum(Set<Integer> s, int k){
		Set lk = new HashSet<Integer>();
		int c;
		
		for(Integer i: s){
			if(i < k){
				lk.add(i);
			}
		}
		Set<Set<Integer>> r = powerSet(lk);

		for(Set<Integer> si : r){
			int sum = setsum(si);
			if(sum == k){
				return si;
			}
		}
		return null;
	}
	public static void main(String[] args){
		Set<Integer> a = new HashSet<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(8);

		Set<Integer> r = subsum(a, 7);
		if(r != null){
			for(Integer i: r){
				System.out.print(i);
			}
			System.out.println("");
		}
	}

}
