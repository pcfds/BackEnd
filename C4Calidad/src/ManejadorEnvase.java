public class ManejadorEnvase extends  Manejador{

    public void comprobar(Articulo arti)
    {
        if (!arti.getEnvase().equalsIgnoreCase("sano") &&
            !arti.getEnvase().equalsIgnoreCase("casi sano"))
        {
            System.out.println("La calidad del envase no es el esperado. Rechazado y despedir al que lo compró");
        }

        else
        {
            if( this.getSiguiente() != null )
            {
                // Llamamos al método en el siguiente objeto
                this.getSiguiente().comprobar( arti );
            }
        }
    }

}

