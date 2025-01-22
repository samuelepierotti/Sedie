/**
 * Classe Partecipante rappresenta un giocatore
 */
class Partecipante extends Thread {
    /** Array dei posti disponibili nel gioco */
    private Posto sedie[];

    /**
     * Costruttore della classe Partecipante.
     * 
     * Ha come parametro l'array sedie[]
     */
    public Partecipante(Posto sedie[]) {
        this.sedie = sedie;
    }

    /**
     * Metodo run del thread Partecipante. Ogni partecipante cerca di occupare un posto libero.
     */
    public void run() {
        try {
            // Pausa iniziale casuale per far partire i giocatori in momenti diversi
            sleep((int) (Math.random() * 1000));

            // Partecipante cerca di occupare un posto
            for (int i = 0; i < sedie.length; i++) {
                if (sedie[i].occupa()) {
                    System.out.println("Sono il Thread " + this.getName()
                            + ". Sono riuscito a sedermi sul posto " + i);
                    return;
                }
            }
            // Messaggio di sconfitta se nessun posto è disponibile
            System.out.println("Sono il Thread " + this.getName()
                    + ". Ho perso :((((");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
