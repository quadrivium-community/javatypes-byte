package academy.quadrivium.type;

public class ByteBinaryRepresentation {
	public static void main(String[] args) {
		for(int number = 0; number < 256; number++) {
			printTypesComparison(number);
		}
	}

	static void printTypesComparison(int number) {
		System.out.print("\nInteger " + number + " of int type in bits is the ");
		System.out.println(Integer.toBinaryString(number) + ",");
		System.out.println("and casted to byte type it is the " + (byte) number);
	}
}
