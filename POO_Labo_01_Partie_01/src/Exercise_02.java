import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Exercise_02 {

	public static void main(String[] args) throws IOException {
		
			
			final int NB_PARTIS = 3;
			final int NB_BUREAUX = 10;
			
			int totalParParti[] = new int[NB_PARTIS];
			int totalParBureau[] = new int[NB_BUREAUX];
			
			int numeroDuBureau;
			int numeroDuParti;
			int nombreDeVotes;
			
			String ligne;
			
			BufferedReader fichier = new BufferedReader(
					new FileReader("src/votes.txt"));
			
			while ((ligne = fichier.readLine()) != null)
			{
				String tab[] = ligne.split(" ");
				    numeroDuBureau = Integer.parseInt(tab[0]);
				    numeroDuParti = Integer.parseInt(tab[1]);
				    nombreDeVotes = Integer.parseInt(tab[2]);
				
				    totalParBureau[numeroDuBureau-1] += nombreDeVotes;
				    totalParParti[numeroDuParti-1] += nombreDeVotes;
			}
			fichier.close();
			
			
			JTextArea sortie = new JTextArea();
			sortie.append("PARTI\tTOTAL DES VOTES\n");
			for (int i = 0; i < totalParParti.length; i++)
			{
			    sortie.append((i+1) + "\t" + totalParParti[i] + "\n");
			}
			
			sortie.append("\nBUREAU\tTOTAL DES VOTANTS\n");
			for (int i = 0; i < totalParBureau.length; i++)
			{
			    sortie.append((i+1) + "\t" + totalParBureau[i] + "\n");
			}
									
			JOptionPane.showMessageDialog(null, sortie,
			"RÉSULTATS DE L'ÉLECTION", JOptionPane.PLAIN_MESSAGE);

			System.exit(0);

	
	}
}