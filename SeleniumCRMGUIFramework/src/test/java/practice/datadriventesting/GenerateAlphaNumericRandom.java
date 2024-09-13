package practice.datadriventesting;

public class GenerateAlphaNumericRandom {
public static void main(String[] args) {
	int n=20;
	//choose a character random from this string
	String AlphaNumericString="ABCDEF12345678abcdefgh";
	//create StringBuffer size of AlphaNumericString
	StringBuilder sb=new StringBuilder(n);
	for(int i=0;i<n;i++) {
		//generate a random number between 0 to alphanumericString Variable Length
		int index = (int) (AlphaNumericString.length()*Math.random());
		//add character one by one in end of sb
		sb.append(AlphaNumericString.charAt(index));
	}
	System.out.println(sb);
}
}
