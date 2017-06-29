package model;

public class Filme {
	private int idFilme;
	private String titulo;
	private String tituloIngles;
	private int ano;
	private String categoria;
	private double pontuacao;
	
	public Filme(){
	}
	
	public Filme(int idFilme, String titulo, String tituloIngles, int ano, String categoria,
			double pontuacao) {
		this.idFilme = idFilme;
		this.titulo = titulo;
		this.tituloIngles = tituloIngles;
		this.ano = ano;
		this.categoria = categoria;
		this.pontuacao = pontuacao;
	}

	public int getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTituloIngles() {
		return tituloIngles;
	}

	public void setTituloIngles(String tituloIngles) {
		this.tituloIngles = tituloIngles;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getPontuacao() { //OPCIONAL
		if (pontuacao >=0 & pontuacao <=10) {
			return pontuacao + " " + "estrelas";
		} else { 
			return "pontuacao nao registrada";
		}
	}
	
/*	public String getPontuacao() { //OPCIONAL
		if (pontuacao >= 0 & pontuacao <=1) {
			return "0 estrela";
		} else if (pontuacao >= 1 & pontuacao <=2) {
			return "1 estrela";
		} else if (pontuacao >= 2 & pontuacao <=3) {
			return "2 estrelas";
		} else if (pontuacao >= 3 & pontuacao <=4) {
			return "3 estrelas";
		} else if (pontuacao >= 4 & pontuacao <=5) {
			return "4 estrelas";
		} else if (pontuacao >= 5 & pontuacao <=6) {
			return "5 estrelas";
		} else if (pontuacao >= 6 & pontuacao <=7) {
			return "5 estrelas";
		} else if (pontuacao >= 7 & pontuacao <=8) {
			return "5 estrelas";
		} else if (pontuacao >= 8 & pontuacao <=9) {
			return "5 estrelas";
		} else if (pontuacao >= 9 & pontuacao <=10) {
			return "5 estrelas";
		} else if (pontuacao == 10) {
			return "5 estrelas";	
		} else { 
			return "pontuacao nao registrada"; 
		}
	}*/
	
/*	public String getPontuacao() { // OPCIONAL
		if (pontuacao == 1) {
			return "1 estrela";
		} else if (pontuacao == 2) {
			return "2 estrelas";
		} else if (pontuacao == 3) {
			return "3 estrelas";
		} else if (pontuacao == 4) {
			return "4 estrelas";
		} else if (pontuacao == 5) {
			return "5 estrelas";
		} else { 
			return "sem pontuacao"; 
		}
	}*/

	public void setPontuacao(double pontuacao) {
		this.pontuacao = pontuacao;
	}
	
}
