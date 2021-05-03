package lp2g27.biblioteca;
import java.util.GregorianCalendar;
import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String nome;
	protected GregorianCalendar dataNasc;
	
	public Pessoa(String a,GregorianCalendar b){
		nome=a;
		dataNasc=b;
	}
	
	public String getNome(){
		return nome;
	}
	
	public GregorianCalendar getDataNasc(){
		return dataNasc;
	}
	
	public String toString(){
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
		return "\nNome: "+nome+"\nData de Nascimento: "+dataFormatada.format(dataNasc.getTimeInMillis());
	}
}