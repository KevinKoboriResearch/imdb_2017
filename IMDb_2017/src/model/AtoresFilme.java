package model;

public class AtoresFilme {
	private int idAtor;
	private int idFilme;
	private String atorNome;
	private String papel;
	private String descricao;
	
	public AtoresFilme() {
	}
			
	public AtoresFilme(int idAtor, int idFilme, String atorNome, String papel, String descricao) {
		super();
		this.idAtor = idAtor;
		this.idFilme = idFilme;
		this.atorNome = atorNome;
		this.papel = papel;
		this.descricao = descricao;
	}

	public int getIdAtor() {
		return idAtor;
	}

	public void setIdAtor(int idAtor) {
		this.idAtor = idAtor;
	}

	public int getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}

	public String getAtorNome() {
		return atorNome;
	}

	public void setAtorNome(String atorNome) {
		this.atorNome = atorNome;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
