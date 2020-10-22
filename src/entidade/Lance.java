package entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Lance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	private double valor;
	
	@ManyToOne
	private Participante participante;
	
	@ManyToOne
	private Leilao leilao;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Participante getParticipante() {
		return participante;
	}
	public void setParticipante(Participante participante) {
		this.participante = participante;
	}
	
	public double retornaMenorLance() {
		
		return 1.0;
	}
	
	

	
	
}
