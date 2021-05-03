package lp2g27.biblioteca;
import java.util.*;

import static java.util.Calendar.DAY_OF_MONTH;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;

public class Biblioteca implements Serializable{
	private static final long serialVersionUID = 1L;
	protected Hashtable<Integer, Usuario> usuarios;
	protected Hashtable<String, Livro> livros;
	private int politica_devol = 8000;

	public Biblioteca() {
		usuarios = new Hashtable<Integer, Usuario>();
		livros = new Hashtable<String, Livro>();
	}

	public Biblioteca(File a, File b) {
		ObjectInputStream inL;
		ObjectInputStream inU;
		try {
			inU = new ObjectInputStream(new FileInputStream(a));
			inL = new ObjectInputStream(new FileInputStream(b));
			usuarios = (Hashtable<Integer,Usuario>) inU.readObject();
			livros = (Hashtable<String,Livro>) inL.readObject();
			inU.close();
			inL.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo nao encontrado");
		} catch (ClassNotFoundException e) {
			System.out.println("A classe desejada nao foi encontrada");
		} catch (InvalidClassException e) {
			System.out.println("A classe eh invalida");
		} catch (StreamCorruptedException e) {
			System.out.println("O Fluxo de entrada esta corrompido");
		} catch (OptionalDataException e) {
			System.out.println("O argumento passado eh um dado primitivo");
		} catch (IOException e) {
			System.out.println("Erro inesperado aconteceu");
		}
	}

	public void cadastraUsuario(Usuario a) {
		try {
			usuarios.put(a.getCod(), a);
		} catch (NullPointerException e) {
			System.out.println("O objeto nao existe");
		}
	}

	public void cadastraLivro(Livro a) {
		try {
			livros.put(a.getCod(), a);
		} catch (NullPointerException e) {
			System.out.println("O objeto nao existe");
		}
	}

	public void salvaArquivo(Hashtable a, String b){
		ObjectOutputStream arq;
		File temp=new File(b+".txt");
		try {
			arq = new ObjectOutputStream(new FileOutputStream(temp));
			arq.writeObject(a);
			arq.close();
		}catch (InvalidClassException e) {
			System.out.println("A classe eh invalida");
		}catch (NotSerializableException e) {
			System.out.println("A classe nao implementa 'Serializable' ");
		}catch (IOException e) {
			System.out.println(e);
		}
	}

	public void leArquivo(String a) {
		ObjectInputStream arq;
		BufferedReader inData=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("1.Livros \n 2.Usuarios");
		int i;
		try {
			i=Integer.parseInt(inData.readLine());
			if (i==1) {
				arq = new ObjectInputStream(new FileInputStream(a));
				usuarios = (Hashtable<Integer, Usuario>) arq.readObject();
				arq.close();
			}else if (i==2) {
				arq = new ObjectInputStream(new FileInputStream(a));
				livros = (Hashtable<String, Livro>) arq.readObject();
				arq.close();
			}else{
				System.out.println("Digito invalido");
			}
		}catch(FileNotFoundException e){
			System.out.println("\nArquivos nao encontrado, tente novamente por favor");
		}
		catch (ClassNotFoundException e) {
			System.out.println("\nA classe desejada nao foi encontrada");
		}catch (InvalidClassException e) {
			System.out.println("\nA classe eh invalida");
		}catch (StreamCorruptedException e) {
			System.out.println("\nO Fluxo de entrada esta corrompido");
		}catch (OptionalDataException e) {
			System.out.println("\nO argumento passado eh um dado primitivo");
		}catch(NumberFormatException e){
			System.out.println("\nDado incorreto");
		}catch (IOException e) {
			System.out.println("\nErro inesperado aconteceu");
		}
	}

	public void emprestaLivro(Usuario a, Livro b) throws CopiaNaoDisponivelEx {
		GregorianCalendar atual = new GregorianCalendar();
		GregorianCalendar devol = new GregorianCalendar();
		devol.add(DAY_OF_MONTH, politica_devol);
		try{
			b.empresta();
			a.addLivroHist(atual,devol,b.getCod());
			b.addUsuarioHist(atual,devol,a.getCod());
		}catch(CopiaNaoDisponivelEx e){
			throw new  CopiaNaoDisponivelEx();
		}
	}
	
	public void devolveLivro(Usuario a, Livro b) throws NenhumaCopiaEmprestadaEx{
		GregorianCalendar atual= new GregorianCalendar();
		ArrayList historico=a.getHistorico();
		int i;
		try{
			for(i=0;i<=historico.size();i++){
				if(((((Emprestimo)historico.get(i)).getCod()).equals(b.getCod()))){
					b.devolve();
					if((((Emprestimo)historico.get(i)).getDataD()).before(atual)){
						System.out.println("O livro foi entregue com atraso, uma multa sera cobrada\n");
						a.setDevolvido(i);
					}else{
						System.out.println("O livro foi entregue com sucesso\n");
						a.setDevolvido(i);
					}
					break;
				}
			}
			if (i==historico.size()){
				System.out.println("Este usuario nunca pegou o livro emprestado\n");
			}
		}catch(NenhumaCopiaEmprestadaEx e){
			throw new NenhumaCopiaEmprestadaEx();
		}
	}
	
	public String imprimeLivros(){
		int i;
		ArrayList<Livro> temp=new ArrayList<Livro>(livros.values());
		ArrayList<String> temp2 = new ArrayList<String>();
		for(i=0;i<livros.size();i++){
			temp2.add((temp.get(i)).getTitulo());
		}
		Collections.sort(temp2);
		return temp2.toString();
	}
	
	public String imprimeUsuarios(){
		int i;
		ArrayList<Usuario> temp=new ArrayList<Usuario>(usuarios.values());
		ArrayList<String> temp2 = new ArrayList<String>();
		for(i=0;i<usuarios.size();i++){
			temp2.add((temp.get(i)).getNome());
		}
		Collections.sort(temp2);
		return temp2.toString();
	}
	
	public Usuario getUsuario(int a) throws UsuarioNaoCadastradoEx{
		try{
			return usuarios.get(a);
		}catch(NullPointerException e){
			throw new UsuarioNaoCadastradoEx();
		}
	}
	
	public Livro getLivro(String a) throws LivroNaoCadastradoEx{
		try{
			return livros.get(a);
		}catch(NullPointerException e){
			throw new LivroNaoCadastradoEx();
		}
	}
	
	public  Hashtable getUsuarios(){
		return usuarios;
	}
	
	public Hashtable getLivros(){
		return livros;
	}
	
	public void setDevol(int a){
		if (politica_devol==8000){
			politica_devol=a;
		}
		else{
			System.out.println("A politica de devolucao ja foi escolhida");
		}
	}
	
}