package edu.misena.clasesJava.model;

public class ItemFactura{
    private Producto producto;
    private int cantidad;

public ItemFactura(Producto producto, int cantidad){
    this.producto=producto;
    this.cantidad=cantidad;
}


public Producto getProducto() {
    return producto;
}

public void setProducto(Producto producto) {
    this.producto = producto;
}

public int getCantidad() {
    return cantidad;
}

public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
}

    // metodo para calcular el importe de un producto.
    public float calcularImporte(){
        return (float) (cantidad * producto.getPrecio());
        // operacion es catidad * precio que tiene el objeto producto
    }

    // metodo para mostrar informacion del item registrado.
    @Override
    public String toString() {
        return producto +
                "\t" + cantidad +
                "\t" + calcularImporte();
    }
}




