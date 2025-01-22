/**
 * Classe Posto rappresenta una sedia nel gioco.
 */
class Posto {
    /** Flag che indica se il posto è occupato */
    private boolean occupato;

    /**
     * Costruttore della classe Posto. Inizializza il posto come libero.
     */
    public Posto() {
        occupato = false;
    }

    /**
     * Metodo sincronizzato per controllare se il posto è libero.
     * 
     * restituisce true se il posto è libero, altrimenti false
     */
    public synchronized boolean libero() {
        return (!occupato);
    }

    /**
     * Metodo sincronizzato per occupare il posto se è libero.
     * 
     * restituisce true se l'occupazione ha avuto successo, altrimenti false
     */
    public synchronized boolean occupa() {
        if (occupato) {
            return false;
        } else {
            occupato = true;
            return true;
        }
    }
}
