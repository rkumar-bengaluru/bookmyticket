package com.turing;

import java.util.Arrays;

public class Turing02 {

	public void rotateright(int[] data, int k) {
		for (var j = 0; j < k; j++) {
			int last = data[data.length - 1];
			for (int i = 0; i <= data.length - 1; i++) {
				int t = data[i];
				data[i] = last;
				last = t;
			}
		}
	}

	public static void main(String[] args) {
		try {
			int[] i = { 1, 2, 3, 4, 5, 6, 7 };
			Turing02 t = new Turing02();
			t.rotateright(i, 3);
			System.out.println(Arrays.toString(i));
			int[] k = { -1,-100,3,99 };
			t.rotateright(k, 2);
			System.out.println(Arrays.toString(k));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
