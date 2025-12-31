package EqualExpression;

public class Main {
	public static void main(String[] args) {
		System.out.println(doubleExpression(0.1, 0.2, 0.3)); 
	}
	static boolean doubleExpression(double a, double b, double c) {
		double exp = a + b;
		double eps = 1E-4;
    return Math.abs(exp - c) < eps;
}
}
