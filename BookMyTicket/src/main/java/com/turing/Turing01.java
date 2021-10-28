package com.turing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Turing01 {

	

	public void swap(int[] data, int i, int j) {
		int t = data[i];
		data[i] = data[j];
		data[j] = t;
	}

	public void merge(int[] data, int l, int m, int r) {
		var i = l;
		var j = m + 1;

		while (i <= m && j <= r) {
			if (data[i] > data[j]) {
				swap(data, i, j);
				i++;
				j++;
				for (int k = j; k <= r; k++) {
					if (data[k - 1] > data[k]) {
						swap(data, k - 1, k);
					}
				}
				j = m + 1;
			} else {
				i++;
				j++;
			}
		}
	}

	public void sort(int[] data, int l, int r) {
		if (l < r) {
			int m = l + (int) Math.floor((r - l) / 2);
			sort(data, l, m);
			sort(data, m + 1, r);
			merge(data, l, m, r);
		}
	}

	public int[] findDup(int[] data) {
		Map<Integer, Integer> dup = new HashMap<>();
		int max = data[0];
		for (int i = 0; i <= data.length - 1; i++) {
			if (dup.get(data[i]) == null) {
				dup.put(data[i], 1);
			} else {
				dup.put(data[i], dup.get(data[i]) + 1);
			}

			if (data[i] > max) {
				max = data[i];
			}
		}
		List<Integer> r = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : dup.entrySet()) {
			if (entry.getValue() > 1) {
				r.add(entry.getKey());
			}
		}
		r.add(max + 1);
		int[] arr = r.stream().mapToInt(i -> i).toArray();
		return arr;
	}

	public static void main(String[] args) {
		try {
			Turing01 t = new Turing01();
			//t.sort(input, 0, input.length - 1);
			int[] input = { 1, 2, 3, 4, 3 };
			int[]  r = t.findDup(input);
			System.out.println(Arrays.toString(r));
			int[] input1 = { 1, 2, 2 };
			r = t.findDup(input1);
			System.out.println(Arrays.toString(r));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
