public abstract class Manejador
{
    private Manejador siguienteManejador;
    // ----------------------------------------
    public Manejador getSiguiente() {
        return this.siguienteManejador;
    }
    // ----------------------------------------
    public void setSiguiente(Manejador m) {
        this.siguienteManejador = m;
    }
    // ----------------------------------------
    public abstract void comprobar(Articulo arti);
}