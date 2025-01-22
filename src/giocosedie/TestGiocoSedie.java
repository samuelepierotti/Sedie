/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * TestGiocoSedie.java
 * Simulazione del gioco "Gioco delle Sedie" dove i partecipanti competono per trovare un posto.
 * L'applicazione utilizza thread per rappresentare i partecipanti e sincronizzazione per la gestione dei posti.
 * @author MC
 */
package giocosedie;

import java.util.logging.Logger;

/**
 * Classe principale per testare il Gioco delle Sedie.
 */
public class TestGiocoSedie {
    /** Numero di sedie disponibili nel gioco */
    private final static int NUMSEDIE = 15;
    /** Logger per la gestione dei messaggi di log */
    private static Logger logger = Logger.getLogger("GiocoSedie.TestGiocoSedie");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crea un array di oggetti Posto per rappresentare le sedie nel gioco
        Posto sedie[] = new Posto[NUMSEDIE];

        // Inizializza ogni elemento dell'array sedie[] con un nuovo oggetto Posto
        for (int k = 0; k < sedie.length; k++) {
            sedie[k] = new Posto();
        }

        // Crea e avvia un thread Display per monitorare lo stato delle sedie
        Display display = new Display(sedie);
        logger.info("Sto facendo partire il Display.\n");
        display.start();

        // Crea un array di thread Partecipante di dimensione NUMSEDIE + 1
        Partecipante array[] = new Partecipante[NUMSEDIE + 1];
        for (int i = 0; i < NUMSEDIE + 1; i++) {
            array[i] = new Partecipante(sedie);
            logger.info("Sto facendo partire il thread id: " + array[i].getId() + " name: " + array[i].getName() + "\n");
            array[i].start();
        }
    }
}
