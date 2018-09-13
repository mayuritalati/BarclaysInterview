package com.mayuri;
import java.util.Stack;

public class CalculateProfit {

	public static void main(String[] args) {
		int n = 6;
		int[] villageProfit = { 1, 2, 3, 4, 9, 8 };
		boolean[][] possiblePath = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			possiblePath[i][i] = true;
			for (int j = i + 1; j < n; j++) {
				if (villageProfit[j] % villageProfit[i] == 0) {
					possiblePath[i][j] = true;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(possiblePath[i][j] + ", ");
			}
			System.out.println();
		}

		int col, row;
		Stack<Integer> porfitStack = new Stack<Integer>();
		Stack<Integer> rowStack = new Stack<Integer>();
		Stack<Integer> colStack = new Stack<Integer>();
		int maxProfit = 0;
		col = 0;
		row = 0;
		while (col < n) {
			if (possiblePath[row][col]) {
				rowStack.push(row);
				colStack.push(col);
				porfitStack.push(villageProfit[col]);
				maxProfit += villageProfit[col];
				row = col;
			}
			col++;
		}
		System.out.println(maxProfit);
		while (!rowStack.isEmpty()) {
			System.out.print(rowStack.pop() + ", ");
		}
		System.out.println();
		while (!colStack.isEmpty()) {
			System.out.print(colStack.pop() + ", ");
		}
		System.out.println();
		while (!porfitStack.isEmpty()) {
			System.out.print(porfitStack.pop() + ", ");
		}
	}
}
