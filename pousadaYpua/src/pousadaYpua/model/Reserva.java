package pousadaYpua.model;

public class Reserva {
	private String dataEntrada;
	private String dataSaida;
	private String numeroPedido;
	private Clientes cliente;
	private Quarto quarto;
	
	
	
	public Reserva(String dataEntrada, String dataSaida) {
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		
	}
	public Reserva(String dataEntrada, String dataSaida, String numeroPedido, Clientes cliente, Quarto quarto) {
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.numeroPedido = numeroPedido;
		this.cliente = cliente;
		this.quarto = quarto;
		
	}
	public String getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public String getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}
	public String getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	public Clientes getCliente() {
		return cliente;
	}
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	



}
