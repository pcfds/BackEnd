public class ManejadorLote extends Manejador {
    public void comprobar(Articulo arti) {
        if (arti.getLote() < 1000) {
            int difMenorLote = 1000 - arti.getLote();
            System.out.println("Rechazado por el numero de lote inferior de " + difMenorLote);
        } else if (arti.getLote() > 2000) {
            int difMayorLote = arti.getLote() - 2000;
            System.out.println("Rechazado por el numero de lote mayor de " + difMayorLote);
        } else {
            if (this.getSiguiente() != null) {
                // Llamamos al método en el siguiente objeto
                this.getSiguiente().comprobar(arti);
            }
        }
    }
}
