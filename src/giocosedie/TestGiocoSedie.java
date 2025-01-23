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

import java.util.Scanner;
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
        // Scanner per ottenere l'input dell'utente
        Scanner scanner = new Scanner(System.in);
        
        int numPartecipanti = 0;
        boolean check = false;

        // Richiesta del numero di partecipanti con ciclo while: se il valore inserito non è valido ripete la richiesta fin quando non ne viene inserito uno valido
        while (!check) {
            try {
                System.out.print("Inserisci il numero di partecipanti (maggiore di " + NUMSEDIE + "): ");
                numPartecipanti = scanner.nextInt();
                
                // Se il numero inserito è <= NUMSEDIE, solleva un'eccezione
                if (numPartecipanti <= NUMSEDIE) {
                    throw new IllegalArgumentException();
                }
                
                check = true; // Input valido, uscita dal ciclo

            } catch (IllegalArgumentException e) {
                System.out.println("Errore: Il numero di partecipanti deve essere maggiore del numero di sedie"); // Messaggio di errore in caso di input <= NUMSEDIE
            } catch (Exception e) {
                System.out.println("Inserisci un numero intero valido."); // Messaggio di errore generico
                scanner.nextLine(); // Pulizia dell'input buffer in caso di errore
            }
        }
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
        Partecipante array[] = new Partecipante[numPartecipanti];
        for (int i = 0; i < numPartecipanti; i++) {
            array[i] = new Partecipante(sedie);
            logger.info("Sto facendo partire il thread id: " + array[i].getId() + " name: " + array[i].getName() + "\n");
            array[i].start();
        }
        
        scanner.close(); // Chiudere lo scanner
    }
}
