/**
 * Classe Display monitora e visualizza lo stato delle sedie durante il gioco.
 */
class Display extends Thread {
    /** Array di posti da monitorare */
    private Posto sedie[];
    /** Flag per indicare la fine del gioco */
    private boolean endgame;

    /**
     * Costruttore della classe Display.
     * 
     * Ha come parametro l'array sedie[]
     */
    public Display(Posto sedie[]) {
        this.sedie = new Posto[sedie.length];
        for (int s = 0; s < sedie.length; s++) {
            this.sedie[s] = sedie[s];
        }
    }

    /**
     * Metodo run del thread Display. Visualizza lo stato di occupazione dei posti.
     */
    public void run() {
        try {
            while (!endgame) {
                int count = 0;

                // Pausa casuale per aggiornamento dello stato
                sleep((int) (Math.random() * 250));

                // Visualizza lo stato delle sedie
                for (int i = 0; i < sedie.length; i++) {
                    if (sedie[i].libero()) {
                        System.out.print("0"); // Posto libero
                    } else {
                        count++;
                        System.out.print("*"); // Posto occupato
                    }
                }
                System.out.println();

                // Controlla se tutti i posti sono occupati
                endgame = (count == sedie.length);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
