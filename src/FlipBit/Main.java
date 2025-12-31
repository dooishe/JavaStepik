package FlipBit;

public class Main {
	public static void main(String[] args) {
		System.out.println(flipBit(6, 1)); 
	}
	static int flipBit(int value, int bitIndex) {
    return value ^ (1 << (bitIndex-1));
}
}
