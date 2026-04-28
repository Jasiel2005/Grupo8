package grupo8;


import java.util.ArrayList;

public class AlmacenService {

    private ArrayList<Productos> lista;

    public AlmacenService(ArrayList<Productos> lista) {
        this.lista = lista;
    }

    
    public boolean insertar(int id, String desc, double precio, int stock) {
        if (buscarPorId(id) != null) return false; // ID duplicado
        lista.add(new Productos(id, stock, precio, desc));
        return true;
    }
    public boolean insertar (int id,String desc) {
    	return insertar (id,desc,0.0,0);
    }

    
    public boolean modificar(int id, String desc, double precio, int stock) {
        Productos p = buscarPorId(id);
        if (p == null) return false;
        p.setDescripcion(desc);
        p.setPrecio(precio);
        p.setStock(stock);
        return true;
    }

   
    public boolean eliminar(int id) {
        return lista.removeIf(p -> p.getId() == id);
    }

    
    public Productos buscarPorId(int id) {
        return lista.stream()
                    .filter(p -> p.getId() == id)
                    .findFirst()
                    .orElse(null);
    }

    public ArrayList<Productos> getLista() { return lista; }
}
