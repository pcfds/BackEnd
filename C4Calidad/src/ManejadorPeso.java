public class ManejadorPeso extends Manejador {

    public void comprobar(Articulo arti) {
        if (arti.getPeso() < 1200) {
            int difMenorPeso = 1200 - arti.getPeso();
            System.out.println("Rechazado por el peso inferior de " + difMenorPeso);
        } else if (arti.getPeso() > 1300) {
            int difMayorPeso = arti.getPeso() - 1300;
            System.out.println("Rechazado por el peso mayor de " + difMayorPeso);
        } else {
            if (this.getSiguiente() != null) {
                // Llamamos al método en el siguiente objeto
                this.getSiguiente().comprobar(arti);
            }
        }
    }
}




