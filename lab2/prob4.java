package lab2;

import java.util.ArrayList;
import java.util.*;

public class prob4 {

	public static List powerSet(List<Integer> X){
		
		List<Set> ret = new ArrayList<Set>();
		Set<Integer> s = new HashSet<Integer>();
		ret.add(s);
		while(!X.isEmpty()){
			int f = X.remove(0);
			for(int i = 0; i < ret.size(); i++){
				Set<Integer> xs = ret.get(i);
				Set<Integer> t = new HashSet<Integer>();
				if(xs == null){
					break;
				}
				t.addAll(xs);
				if(!xs.contains(f)){
					t.add(f);
					ret.add(t);
				}
				
			}
		}
		return ret;
	}
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(3);
		l.add(5);
		l.add(7);
		l.add(11);
		l.add(13);
		l.add(14);
		l.add(17);
		List<Set> r = powerSet(l);
		for(Set<Integer> s: r){
			for(Integer i: s){
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
