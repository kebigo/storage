package TodoElProyecto;

/**
 * Constructor para crear una linea en la facturacion
*/
public class LineaFactura {

	public int Codigo;
	public double totalLinea;

	public LineaFactura(int Codigo, double totalLinea) {
		this.Codigo = Codigo;
		this.totalLinea = totalLinea;
	}

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int codigo) {
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