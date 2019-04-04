import java.io.*;

public class ContaLetras{
		public static void main(String[] args){
			int[] letterCount = new int[26];
			BufferedReader inData=new BufferedReader(new InputStreamReader(System.in));
			String line = new String();
			System.out.println("Insira uma linha:");
			try{
					line = inData.readLine();
				} catch(IOException exc){
					System.out.println("oloco");
				}
			int location;
			int index;
			char letter;
			while(!line.isEmpty()){ //Poderia usar o line.Equals(), o "!" quer dizer negação, então ele troca de True pra false e de False pra True
				for(location=0;location<line.length();location++){
					letter=line.charAt(location);
					if ((letter >= 'A' && letter <='Z') || (letter >='a' && letter <= 'z')){
						index = (int)Character.toUpperCase(letter) - (int) 'A';
						letterCount[index]=letterCount[index]+1;
					}
				}
				
				for (index=0; index<letterCount.length; index++){
					System.out.println("The total number of "+(char) (index+ (int) 'A')+ "'s is "+letterCount[index]);
					letterCount[index]=0;
				}
				System.out.println("Insira uma nova linha:");
				try{
					line = inData.readLine();
				} catch(IOException exc){
					System.out.println("oloco");
				}
				
			}
		}
}
