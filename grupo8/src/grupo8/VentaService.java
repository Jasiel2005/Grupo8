package grupo8;



public class VentaService {

    public static double calcularTotal(double precio, int cantidad,
                                        double descuentoPct, double igvPct) {
        double subtotal = precio * cantidad;
        double conDesc  = subtotal * (1 - descuentoPct / 100);
        double conIgv   = conDesc  * (1 + igvPct   / 100);
        return conIgv;
    }

    public static double subtotal(double precio, int cantidad) {
        return precio * cantidad;
    }

    public static double aplicarDescuento(double subtotal, double pct) {
        return subtotal * (1 - pct / 100);
    }
    public static double aplicarDescuento(double subtotal) {
    	return subtotal *(1 - 10.0/100);
    }

    public static double aplicarIGV(double base, double igvPct) {
        return base * (1 + igvPct / 100);
    }
}