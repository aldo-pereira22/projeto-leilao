package entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import dao.LanceDao;
import dao.LeilaoDao;

@Entity
public class Lance {
	LanceDao ldao = new LanceDao();
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	private double valor;
	
	@ManyToOne
	private Participante participante;
	
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
	
	
	public double retornaMaiorLance() {
		List<Lance>lista = new ArrayList<Lance>();
		lista = ldao.lista();
		
		
		return 1.0;
	}
	
	
}
