package edu.misena.clasesJava.model;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {
    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] items;

    /**
     * Defina Índice actual en el arreglo de ítems.
     */
    private int indiceItems=0;

    /**
     * Define una constante de Número máximo de ítems que una factura puede contener llamarla MAX_ITEMS y asignarle un valor inicial.
     */
    private static int MAX_ITEMS=5;

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
        this.items = new ItemFactura[MAX_ITEMS];
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

    public void addItemFactura(ItemFactura item) {
        if (indiceItems < MAX_ITEMS){
            this.items[indiceItems]=item;
            indiceItems++;
        }
        //valida si el indiceItems < MAX_ITEMS
        // agrega en el arreglo items los items

    }

    /**
     * Calcula el importe total de la factura sumando el importe de cada ítem en la lista.
     *
     * @return el importe total de la factura, como un valor de tipo {@code float}.
     *         Si la lista de ítems está vacía o todos los ítems son {@code null}, el valor retornado será 0.0.
     */
    public float calcularTotal() {

        /**
         * Itera sobre la lista de ítems de la factura. Para cada ítem:
         * - Si el ítem es {@code null}, se omite y se pasa al siguiente ítem.
         * - Si el ítem no es {@code null}, se llama al método {@code calcularImporte()}
         *   y se suma el valor retornado a la variable {@code total}.
         */
        float total=0;
        for (ItemFactura item: this.items){
            if (item != null){
                total += item.calcularImporte();
            }
        }
        return total;

        // Devuelve el importe total de la factura.

    }

    // prepara el detalle de la factura
    public String generarDetalle() {
        StringBuilder sb = new StringBuilder("Factura Nº: ");
        sb.append(folio)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\t NIF: ")
                .append(cliente.getNif())
                .append("\nDescripción: ")
                .append(this.descripcion)
                .append("\n");

        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        sb.append("Fecha Emisión: ")
                .append(df.format(this.fecha))
                .append("\n")
                .append("\n#\tNombre\t$\tCant.\tTotal\n");

        for(ItemFactura item: this.items){
            if(item == null){
                continue;
            }
            sb.append(item)
                    .append("\n");
        }
        sb.append("\nGran Total: ")
                .append(calcularTotal());

        return sb.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }
}
