package lp2g27.biblioteca;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.io.Serializable;

public class EmprestadoPara implements Serializable{
	private static final long serialVersionUID = 1L;
	protected GregorianCalendar dataE;
	protected GregorianCalendar dataD;
	protected int cod;
	
	public EmprestadoPara(GregorianCalendar a, GregorianCalendar b, int c){
		dataE=a;
		dataD=b;
		cod=c;
	}
	
	public int getCod(){
		return cod;
	}
	
	public GregorianCalendar getDataE(){
		return dataE;
	}
	
	public GregorianCalendar getDataD(){
		return dataD;
	}
	
	public String toString(){
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
		return "\nData de Emprestimo:"+dataFormatada.format(dataE.getTimeInMillis())+"\nData de devolucao:"+dataFormatada.format(dataD.getTimeInMillis())+"\nCodigo do usuario:"+cod;
	}
}
	