package lp2g27.biblioteca;
import java.util.Collection;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.io.*;

public class Livro  implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String codigoLivro;
	protected String titulo;
	protected String categoria;
	protected int qnt;
	protected int emprest;
	protected ArrayList<EmprestadoPara> historico= new ArrayList<EmprestadoPara>();
	
	public Livro(String a,String b,String c,int d){
		codigoLivro=a;
		titulo=b;
		categoria=c;
		qnt=d;
	}
	
	public Livro(String a){
		titulo=a;
	}
	
	public void empresta()throws CopiaNaoDisponivelEx{
		if (emprest==qnt){
			throw new CopiaNaoDisponivelEx();
		}else{
			emprest+=1;
		}
	}
	
	public void devolve()throws NenhumaCopiaEmprestadaEx{
		if (emprest==0){
			throw new NenhumaCopiaEmprestadaEx();
		}else{
			emprest-=1;
		}
	}
	
	public void addUsuarioHist(GregorianCalendar a, GregorianCalendar b, int c){
		EmprestadoPara livro=new EmprestadoPara(a,b,c);
		historico.add(livro);
	}
	
	public String getCod(){
		return codigoLivro;
	}
	
	public String getTitulo(){
		return titulo;
	}
	
	public String getCategoria(){
		return categoria;
	}
	
	public int getQnt(){
		return qnt;
	}
	
	public int getEmprest(){
		return emprest;
	}
	
	public ArrayList getHistorico(){
		return historico;
	}
	
	public String toString(){
		return "\nNome do Livro: "+titulo+"\nCategoria: "+categoria+"\nCodigo: "+codigoLivro+"\nQuantidade: "+qnt+"\nEmprestados: "+emprest+"\nHistorico: "+historico;
	}
}
	
	
	