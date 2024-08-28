package edu.misena.clasesJava.model;
import java.util.Date;
import edu.misena.clasesJava.model.ItemFactura;

public class Factura {
    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] items;

    /**
     * Defina Índice actual en el arreglo de ítems.
     */
    private int indiceActual=0;

    /**
     * Define una constante de Número máximo de ítems que una factura puede contener llamarla MAX_ITEMS y asignarle un valor inicial.
     */
    private static int MAX_ITEMS=0;

    /**
     * Crear una variable estatica para El último folio asignado a una factura.
     * Crea un Este campo se usa para generar nuevos folios únicos para cada instancia de {@code Factura}.
     */
    private static int ultimoFolio=0;


/**
 * Crear el constructor inicializa la descripción, el cliente, y el arreglo de ítems. Asigna un folio único a la factura e
 * inicializa la fecha de emisión a la fecha actual.
 * @param descripcion La descripción de la factura.
 * @param cliente El cliente asociado a la factura.
 */
    public Factura (String descripcion, Cliente cliente){
        this.folio=(++ultimoFolio);
        this.cliente=cliente;
        this.fecha=new Date();
        this.descripcion=descripcion;
        ItemFactura[][] ItemFactura = new ItemFactura[0][];
        this.items=ItemFactura[MAX_ITEMS];
    }

    // siguen los getter y setters


    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFactura[] getItems() {
        return items;
    }

    public void setItems(ItemFactura[] items) {
        this.items = items;
    }
}
