package entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import dao.LanceDao;

@Entity
public class Leilao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String descricao;
	private String dataCriacao;
	private double valorInicial;
	private double valorArremate;
	private String situacao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public double getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(double valorInicial) {
		this.valorInicial = valorInicial;
	}

	public double getValorArremate() {
		return valorArremate;
	}

	public void setValorArremate(double valorArremate) {
		this.valorArremate = valorArremate;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;

	}

	double retornaMaiorLance(Leilao leilao) {
		LanceDao lanceDao = new LanceDao();
		List<Lance>listaLance = new ArrayList<Lance>();
		
		listaLance = lanceDao.lista();
		double maiorLance = -99;
		
		for(Lance lance : listaLance ) {
			
			if( leilao.getId() == lance.getLeilao().getId() ) {
				if(lance.getValor() > maiorLance) {
					maiorLance = lance.getValor();
				}
			}
		}
		
		return maiorLance;
	}

}
