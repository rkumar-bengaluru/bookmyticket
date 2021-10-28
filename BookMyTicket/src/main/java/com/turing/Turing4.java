package com.turing;

import java.util.HashMap;
import java.util.Map;

public class Turing4 {
	
	public int countXPlusOne(int[] data) {
		Map<Integer,Boolean > map = new HashMap<>();
		int res = 0;
		for(int i = 0 ; i <= data.length -1; i++) {
			map.put(data[i] - 1, true);
		}
		for(int i = 0 ; i <= data.length -1; i++) {
			if(map.containsKey(data[i])) {
				res++;
			}
		}
		return res;
	}
	

	public static void main(String[] args) {
		try {
			int[] a = {1,2,3};
			Turing4 t = new Turing4();
			System.out.println("a-" + t.countXPlusOne(a));
			int[] b = {1,1,3,3,5,5,7,7};
			System.out.println("b-" + t.countXPlusOne(b));
			int[] c = {1,3,2,3,5,0};
			System.out.println("c-" + t.countXPlusOne(c));
			int[] d = {1,1,2,2};
			System.out.println("d-" + t.countXPlusOne(d));
			int[] e = {1,1,2};
			System.out.println("e-" + t.countXPlusOne(e));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
