import lp2g27.biblioteca.*;
import java.util.*;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;

public class Ex2 implements Serializable{
	private static final long serialVersionUID = 1L;

	public void Manutencao(Biblioteca a) {
		BufferedReader inData=new BufferedReader(new InputStreamReader(System.in));
		String nome=null;
		String nome2=null;
		int i=1;
		int c;
		System.out.println("\n==== TELA DE MANUTENCAO ====");
		while(i==1){
			try{
				System.out.println("\n1.Salvar arquivos\n2.Sair do Menu");
				c=Integer.parseInt(inData.readLine());
				switch(c){
					case 1:
						System.out.println("\nInsira o nome do arquivo de usuarios:");
						nome=inData.readLine();
						System.out.println("\nInsira o nome do arquivo de livros:");
						nome2=inData.readLine();
						a.salvaArquivo(a.getUsuarios(),nome);
						a.salvaArquivo(a.getLivros(),nome2);
						break;
					case 2:
						i=0;
						break;
					default:
						System.out.println("\nEscolha nao disponivel");
						break;
				}
			}catch(NumberFormatException e){
				System.out.println("\nDado incorreto");
			}catch(IOException e){
				System.out.println(e);
			}
		}

	}

	public void Devolve(Biblioteca a){
		BufferedReader inData=new BufferedReader(new InputStreamReader(System.in));
		String codL=null;
		int codU;
		Usuario usuario=null;
		Livro livro=null;
		int i=1;
		int c;
		Enumeration l;
		System.out.println("\n==== TELA DE DEVOLUCAO ====");
		while (i==1){
			try{
				System.out.println("\n1.Exibir cadastro de usuarios\n2.Fazer devolucao de livro\n3.Sair do Menu");
				c=Integer.parseInt(inData.readLine());
				switch(c){
					case 1:
						l=(a.getUsuarios()).elements();
						while(l.hasMoreElements()){
							System.out.println(l.nextElement());
						}
						break;
					case 2:
						System.out.println("\nDigite o codigo do usuario");
						codU=Integer.parseInt(inData.readLine());
						usuario=a.getUsuario(codU);
						System.out.println("\nDigite o codgo do livro a ser devolvido");
						codL=inData.readLine();
						livro=a.getLivro(codL);
						a.devolveLivro(usuario,livro);
						System.out.println("\nDevolucao feita com sucesso!\n"+usuario+"\n"+livro);	
						break;
					case 3:
						i=0;
						break;
					default:
						System.out.println("\nEscolha nao disponivel");
						break;
				}
			}catch(UsuarioNaoCadastradoEx e){
				System.out.println(e);
			}catch(LivroNaoCadastradoEx e){
				System.out.println(e);
			}catch(NenhumaCopiaEmprestadaEx e){
				System.out.println(e);
			}catch(NumberFormatException e){
				System.out.println("\nDado incorreto");
			}catch(NoSuchElementException e){
				System.out.println(e);
			}catch(IOException e){
				System.out.println(e);
			}
		}
	}	

	public void Relatorio(Biblioteca a){
		System.out.println("\n====TELA DE RELATORIO====");
		BufferedReader inData=new BufferedReader(new InputStreamReader(System.in));
		String codL=null;
		int codU;
		int i=1;
		int c;
		while(i==1){
			try{
				System.out.println("\n1,Acervo de livros\n2.Cadastro de usuarios\n3.Detalhes de um usuario especifico\n4.Detalhes de um livro especifico\n5.Sair do Menu");
				c=Integer.parseInt(inData.readLine());
				switch(c){
					case 1:
						System.out.println(a.imprimeLivros());
						break;
					case 2:
						System.out.println(a.imprimeUsuarios());
						break;
					case 3:
						System.out.println("\ninsira o codigo do usuario");
						codU=Integer.parseInt(inData.readLine());
						System.out.println(a.getUsuario(codU));
						break;
					case 4:
						System.out.println("\ninsira o codigo do livro");
						codL=inData.readLine();
						System.out.println(a.getLivro(codL));
						break;
					case 5:
						i=0;
						break;
					default:
						System.out.println("\nEscolha nao disponivel");
						break;
				}
			}catch(NumberFormatException e){
				System.out.println("\nDado incorreto");
			}catch(UsuarioNaoCadastradoEx e){
				System.out.println(e);
			}catch(LivroNaoCadastradoEx e){
				System.out.println(e);
			}catch(NoSuchElementException e){
				System.out.println(e);
			}catch(IOException e){
				System.out.println(e);
			}
		}	
	}

	public void Emprestimo(Biblioteca a){
		BufferedReader inData=new BufferedReader(new InputStreamReader(System.in));
		String codL=null;
		int codU;
		Usuario usuario=null;
		Livro livro=null;
		int i=1;
		int c;
		Enumeration l;
		System.out.println("\n==== TELA DE EMPRESTIMO ====");
		while(i==1){
			try{
				System.out.println("\n1.Exibir cadastro de livros\n2.Fazer emprestimo de livro\n3.Sair do Menu");
				c=Integer.parseInt(inData.readLine());
				switch(c){
					case 1:
						l=(a.getLivros()).elements();
						while(l.hasMoreElements()){
								System.out.println(l.nextElement());
						}
						break;
					case 2:
						System.out.println("\nDigite o codigo do usuario");
						codU=Integer.parseInt(inData.readLine());
						usuario=a.getUsuario(codU);
						System.out.println("\nDigite o codgo do livro a ser emprestado");
						codL=inData.readLine();
						livro=a.getLivro(codL);
						a.emprestaLivro(usuario,livro);
						System.out.println("\nEmprestimo feito com sucesso!"+usuario+"\n"+livro);	
						break;
					case 3:
						i=0;
						break;
					default:
						System.out.println("\nEscolha nao disponivel");
						break;
				}
			}catch(UsuarioNaoCadastradoEx e){
				System.out.println(e);
			}catch(LivroNaoCadastradoEx e){
				System.out.println(e);
			}catch(CopiaNaoDisponivelEx e){
				System.out.println(e);
			}catch(NumberFormatException e){
				System.out.println("\nDado incorreto");
			}catch(IOException e){
				System.out.println(e);
			}
		}
	}

	public void Cadastro(Biblioteca a){
		BufferedReader inData=new BufferedReader(new InputStreamReader(System.in));
		String nome=null;
		String codL=null;
		String endereco=null;
		String titulo=null;
		String categoria=null;
		GregorianCalendar dataNasc=null;
		Usuario usuario=null;
		Livro livro=null;
		int dia,mes,ano,codU,qnt,i=1,c;
		System.out.println("\n==== TELA DE CADASTRO ====");
		while (i==1){
			try{
				System.out.println("\n1.Cadastro de novo usuario\n2.Cadastro de novo livro\n3.Salvar arquivo\n4.Sair do Menu");
				c=Integer.parseInt(inData.readLine());
				switch(c){
					case 1:
						System.out.println("\nDigite seu nome: ");
						nome=inData.readLine();
						System.out.println("\nDigite seu endereco: ");
						endereco=inData.readLine();
						System.out.println("\nDigite o dia de seu nascimento");
						dia=Integer.parseInt(inData.readLine());
						System.out.println("\nDigite o mes  de seu nascimento");
						mes=Integer.parseInt(inData.readLine())-1;
						System.out.println("\nDigite o ano de seu nascimento");
						ano=Integer.parseInt(inData.readLine());
						System.out.println("\nDigite o codigo que gostaria de utilizar (em numero)");
						codU=Integer.parseInt(inData.readLine());
						dataNasc=new GregorianCalendar(ano,mes,dia);
						usuario=new Usuario(nome,dataNasc,endereco,codU);
						a.cadastraUsuario(usuario);
						break;
					case 2:
						System.out.println("\nDigite o titulo: ");
						titulo=inData.readLine();
						System.out.println("\nDigite a categoria: ");
						categoria=inData.readLine();
						System.out.println("\nDigite a quantidade de exemplares");
						qnt=Integer.parseInt(inData.readLine());
						System.out.println("\nDigite o codigo que gostaria de utilizar");
						codL=inData.readLine();
						livro=new Livro(codL,titulo,categoria,qnt);
						a.cadastraLivro(livro);
						break;
					case 3:
						System.out.println("\n1.Salvar cadastro de usuarios\n2.Salvar cadastro de livros");
						c=Integer.parseInt(inData.readLine());
						System.out.println("\nDigite o nome do arquivo ");
						nome=inData.readLine();
						if (c==1){
							a.salvaArquivo(a.getUsuarios(),nome);
						}else if(c==2){
							a.salvaArquivo(a.getLivros(),nome);
						}else{
							System.out.println("\nEscolha nao disponivel");
						}
						break;
					case 4:
						i=0;
						break;
					default:
						System.out.println("\nEscolha nao disponivel");
						break;
				}
			}catch(FileAlreadyExistsException e){
				System.out.println("\nO arquivo ja existe!");
			}catch(NumberFormatException e){
				System.out.println("\nO dado inserido esta incorreto");
			}catch(IOException e){
				System.out.println("\nAlgo de errad aconteceu");
			}
		}
	}

	public static void main(String[] args){
		BufferedReader inData=new BufferedReader(new InputStreamReader(System.in));
		int i=1;
		File usuarios=null;
		File livros=null;
		String nlivros=null;
		String nusuarios=null;
		Biblioteca a=null;
		Ex2 programa=new Ex2();
		int c;
		int pol;
		System.out.println("\n==== BEM VINDO AO SISTEMA DE BIBLIOTECA SHAO007 ====\n1.Cria uma nova biblioteca\n2.Carregar uma biblioteca");
		while(i==1){
			try{
				c=Integer.parseInt(inData.readLine());
				switch(c){
					case 1:
						a=new Biblioteca();
						System.out.println("\nInsira quantos dias um usuario pode ficar com o livro");
						pol=Integer.parseInt(inData.readLine());
						a.setDevol(pol);
						i=0;
						break;
					case 2:
						System.out.println("\nDigite o nome do arquivo onde estao salvos seus usuarios");
						nusuarios=inData.readLine();
						usuarios=new File(nusuarios+".txt");
						System.out.println("\nDigite o nome do arquivo onde estao salvos seus livros");
						nlivros=inData.readLine();
						livros=new File(nlivros+".txt");
						a=new Biblioteca(usuarios,livros);
						i=0;
						break;
					default:
						System.out.println("Insira um numero valido");
						break;
				}
			}catch(NumberFormatException e){
				System.out.println("\nDado invalido");
			}catch(NullPointerException e){
				System.out.println(e);
			}catch(IOException e){
				System.out.println(e);
			}
		}
		i=1;
		while (i==1){
			try{
				System.out.println("\n==== MENU PRINCIPAL ====\n1.Manutencao\n2.Cadastro\n3.Emprestimo\n4.Devolucao\n5.Relatorio\n6.Sair do Programa");
				c=Integer.parseInt(inData.readLine());
				switch(c){
						case 1:
							programa.Manutencao(a);
							break;
						case 2:
							programa.Cadastro(a);
							break;
						case 3:
							programa.Emprestimo(a);
							break;
						case 4:
							programa.Devolve(a);
							break;
						case 5:
							programa.Relatorio(a);
							break;
						case 6:
							i=0;
							break;
						default:
							System.out.println("\nEscolha nao disponivel");
							break;
				}
			}catch(NumberFormatException e){
				System.out.println("Dado invalido");
			}catch(IOException e){
				System.out.println(e);
			}
		}
		System.out.println("\n==== TERMINANDO PROGRAMA ====");
	}
}			