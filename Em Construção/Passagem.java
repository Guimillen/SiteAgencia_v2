package entrega2;


public class Passagem {
	
	//- dadosPassageiro:type = varChar
	//		- empresaAerea:type = varChar
		//	- origem:type = varChar
			//- destino:type = varChar
			//- dataViagem:type = date
			//- horario:type = time
			//- poltrona:type = in
	
	private String dadosPassageiro;
	private String empresaAerea;
	private String origem;
	private String destino;
	private int dataViagem;
	private int horario;
	private int poltrona;
	public String getDadosPassageiro() {
		return dadosPassageiro;
	}
	public void setDadosPassageiro(String dadosPassageiro) {
		this.dadosPassageiro = dadosPassageiro;
	}
	public String getEmpresaAerea() {
		return empresaAerea;
	}
	public void setEmpresaAerea(String empresaAerea) {
		this.empresaAerea = empresaAerea;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public int getDataViagem() {
		return dataViagem;
	}
	public void setDataViagem(int dataViagem) {
		this.dataViagem = dataViagem;
	}
	public int getHorario() {
		return horario;
	}
	public void setHorario(int horario) {
		this.horario = horario;
	}
	public int getPoltrona() {
		return poltrona;
	}
	public void setPoltrona(int poltrona) {
		this.poltrona = poltrona;
	}
	
}
	