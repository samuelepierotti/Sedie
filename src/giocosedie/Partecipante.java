package giocosedie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe Partecipante rappresenta un giocatore
 */
class Partecipante extends Thread {
    /** Array dei posti disponibili nel gioco */
    private Posto sedie[];
    
    private static final String FILE_NAME = "Risultato.txt";

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

            // Il giocatore cerca di occupare un posto
            for (int i = 0; i < sedie.length; i++) {
                if (sedie[i].occupa()) {
                    // Scrive il risultato nel file
                    synchronized (Partecipante.class) { // Sincronizzazione per evitare conflitti tra thread
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
                            writer.write("Posto " + i + " occupato dal thread " + this.getName() + "\n");
                        }
                    }
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
        } catch (IOException e) {
            System.out.println("Errore durante la scrittura nel file");
        }
    }
}
