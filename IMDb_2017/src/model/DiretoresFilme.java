package model;

public class DiretoresFilme {
	private int idDiretor;
	private int idFilme;
	private String diretorNome;
	private String descricao;
	
	public DiretoresFilme(){
	}

	public DiretoresFilme(int idDiretor, int idFilme, String diretorNome, String descricao) {
		super();
		this.idDiretor = idDiretor;
		this.idFilme = idFilme;
		this.diretorNome = diretorNome;
		this.descricao = descricao;
	}

	public int getIdDiretor() {
		return idDiretor;
	}

	public void setIdDiretor(int idDiretor) {
		this.idDiretor = idDiretor;
	}

	public int getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}

	public String getDiretorNome() {
		return diretorNome;
	}

	public void setDiretorNome(String diretorNome) {
		this.diretorNome = diretorNome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
