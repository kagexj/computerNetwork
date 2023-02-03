import java.util.Scanner;
import java.math.*;

public class QuadraticEquation {
	 public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 parametr(0, 1, 2);
		 parametr(0, 0, 5);
		 parametr(1, 2, 1);
		 parametr(0, 0, 0);
		 parametr(1, -7, 11);
		 parametr(1, -2, 1);
		 
		 console(in);
	 }
	 
	 static void console(Scanner in) {
		 Solution solution = new Solution(in);
		 solution.solve();
		 System.out.println();
	 }
	 
	 static void parametr(double a, double b, double c) {
		 Solution solution = new Solution(a, b, c);
		 solution.solve();
		 System.out.println();
	 }
}

class Solution {
	double a, b, c;
	
	Solution(Scanner in) {
		this.a = in.nextDouble();
		this.b = in.nextDouble();
		this.c = in.nextDouble();
	}
	
	Solution (double A, double B, double C) {
		this.a = A;
		this.b = B;
		this.c = C;
	}
	
	public void solve() {
		System.out.println("a = " + a + ", b = " + b + ", c = " + c);
		
		if ((a == 0) && (b == 0) && (c == 0)) {
			System.out.println("Существует бесконечно много решений.");
			return;
		}
		
		if ((a == 0) && (b == 0)) {
			System.out.println("Нет решения.");
			return;
		}
		
		if (a == 0) {
			System.out.println("x = " + -c / b);
			return;
		}
		
		double D = b * b - 4 * a * c;
		
		if (D > 0) {
			double x1 = (-b + Math.sqrt(D)) / (2 * a);
			double x2 = (-b - Math.sqrt(D)) / (2 * a);
			
			System.out.println("x1 = " + x1 +", x2 = "+ x2);
		}
		if (D == 0) {
			System.out.println("x = "+ -b / (2 * a));
		}
		
		if (D < 0) {
			System.out.println("Нет решения.");
		}
	}
}
