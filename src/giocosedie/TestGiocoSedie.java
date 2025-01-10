/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giocosedie;

import java.util.logging.Logger;

/**
 *
 * @author MC
 */
public class TestGiocoSedie {
    private final static int NUMSEDIE = 15;
    private static Logger logger = Logger.getLogger("GiocoSedie.TestGiocoSedie");
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	//istanzia l'array sedie[] di tipo Posto, la cui grandezza è 15 (NUMSEDIE)
        Posto sedie[] = new Posto[NUMSEDIE];
	//crea un oggetto di tipo Posto per ogni elemento dell'array sedie
	for (int k = 0; k < sedie.length; k++)
		sedie[k] = new Posto();

	Display display = new Display(sedie);
	//System.out.println("Sto facendo partire il Display.");
        logger.info("Sto facendo partire il Display.\n");
	display.start();
	//istanzia l'array dei partecipanti, di tipo Partecipante, di grandezza 16
	Partecipante array[] = new Partecipante[NUMSEDIE+1];
	for (int i = 0; i < NUMSEDIE + 1; i++) {
		array[i] = new Partecipante(sedie);
                //System.out.println("Sto facendo partire il thread n." + array[i].getId());
                logger.info("Sto facendo partire il thread id: " + array[i].getId()+" name: "+array[i].getName()+"\n");
                array[i].start();
                }
	}
    }
 
