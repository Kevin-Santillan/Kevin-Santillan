public class Producto {
    private String nombreProducto;
    private String codigo;
    private double precio;
    private int cantidad;
    private boolean estadoCompra;

    public Producto(){
        nombreProducto = "No definido";
        codigo = "No definido";
        precio = 0.0;
        cantidad = 0;
        estadoCompra = false;
    }

    public Producto(String codigo,String nombreProducto, int cantidad, double precio, boolean estadoCompra  ){
        this.codigo = codigo;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.estadoCompra = estadoCompra;
    }
    public String getCodigo(){

        return codigo;

    }

    public String getNombreProducto(){

        return nombreProducto;

    }

    public int getCantidad(){

        return cantidad;

    }
    public double getPrecio(){

        return precio;

    }

    public boolean getEstadoProducto(){

        return estadoCompra;

    }

    public void setNombreProducto(String nombreP){

        nombreProducto = nombreP;
    }

    public void setCantidad(int cantidadP){

        cantidad = cantidadP;
    }

    public void setPrecio(double precioP){

        precio = precioP;
    }

    public void setEstadoProducto(boolean estadoP){

        estadoCompra = estadoP;
    }
    
    
}