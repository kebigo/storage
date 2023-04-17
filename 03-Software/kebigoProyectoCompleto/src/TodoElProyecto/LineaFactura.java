package TodoElProyecto;

public class LineaFactura {

	public String Codigo;
	public double totalLinea;

	public LineaFactura(String Codigo, double totalLinea) {
		this.Codigo = Codigo;
		this.totalLinea = totalLinea;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	public double getTotalLinea() {
		return totalLinea;
	}

	public void setTotalLinea(double totalLinea) {
		this.totalLinea = totalLinea;
	}

	@Override
	public String toString() {
		return "LineaFactura [Codigo=" + Codigo + ", totalLinea=" + totalLinea + "]";
	}
}