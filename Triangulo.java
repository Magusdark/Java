public class Triangulo{
	double l1;
	double l2;
	double l3;
	public Triangulo(double a, double b, double c){
		l1=a;
		l2=b;
		l3=c;
	}
	public static String tipo(double l1,double l2,double l3){
		if (l1==l2 && l2==l3){
			return "Equilatero";
		}
		else if(l1!=l2 && l2!=l3 && l1!=l3){
			return "Escaleno";
		}
		else{
			return "Isosceles";
		}
	}
}