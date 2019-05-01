import java.io.*;
import java.lang.Math;

public class Ex1{
	private static double calcula(double r){
		return r*r*3.14;
	}
	private static double calcula(double a,double b){
		return a*b;
	}
	private static double calcula(double l1,double l2,double l3)throws NotValidTriangleException{
		if (Math.abs(l2-l3)<l1 && l1<l2+l3 && Math.abs(l1-l3)<l2 && l2<l3+l1 && Math.abs(l1-l2)<l3 && l3<l1+l2){
			System.out.println("O triangulo eh:"+Triangulo.tipo(l1,l2,l3));
			double p=(l1+l2+l3)/2;
			return Math.sqrt((p*(p-l1)*(p-l2)*(p-l3)));
		}else{
			throw new NotValidTriangleException();
		}
	}
	public static void main(String[] args){
		try{
			if (args.length<1){
				System.out.println("Numero de argumentos insuficiente");
			}else if(args.length>3){
				System.out.println("O numero de argumentos excessivos");
			}else if(args.length==1){
				System.out.println("A area do circulo eh: "+String.format("%.2f",calcula(Double.parseDouble(args[0])))+" unidades");
			}else if(args.length==2){
				System.out.println("A area do retangulo eh: "+String.format("%.2f",calcula(Double.parseDouble(args[0]),Double.parseDouble(args[1])))+" unidades");
			}else if(args.length==3){
				System.out.println("A area do triangulo eh:"+String.format("%.2f",calcula(Double.parseDouble(args[0]),Double.parseDouble(args[1]),Double.parseDouble(args[2])))+" unidades");
			}
		}
		catch(NotValidTriangleException erro){
			System.out.println(erro);
		}catch(NumberFormatException erro){
			System.out.println("Algum argumento passado nao eh numero");
		}
		
	}
}