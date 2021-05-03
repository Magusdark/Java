package lp2g27.biblioteca;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.io.Serializable;

public class Emprestimo implements Serializable{
	private static final long serialVersionUID = 1L;
	protected GregorianCalendar dataE;
	protected GregorianCalendar dataD;
	protected String cod;
	
	public Emprestimo(GregorianCalendar a, GregorianCalendar b, String c){
		dataE=a;
		dataD=b;
		cod=c;
	}
	
	public String getCod(){
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
		return "\nData de Emprestimo:"+dataFormatada.format(+dataE.getTimeInMillis())+"\nData de devolucao:"+dataFormatada.format(dataD.getTimeInMillis())+"\nCodigo do livro:"+cod;
	}
}
