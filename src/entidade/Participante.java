package entidade;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Participante {

	@Id
	private String cpf;
	
	private String nome;
	
	private String dataNascimento;
	public Participante() {
		// TODO Auto-generated constructor stub
	}
	
	public Participante(String cpf, String nome) {
		super();
		this.cpf = cpf;
		this.nome = nome;
	}
	
	public Participante(String cpf) {
		this.cpf = cpf;
	}
	
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
