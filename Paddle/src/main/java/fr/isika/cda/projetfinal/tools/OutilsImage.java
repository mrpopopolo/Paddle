package fr.isika.cda.projetfinal.tools;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.http.Part;

public class OutilsImage {

	private static File fichierSauvegarde;

	public static String sauvegarderImage(Part fichierEnvoye) throws IOException {
		System.out.println(Paths.get(fichierEnvoye.getSubmittedFileName()).getFileName().toString());
		String[] nomFichierDecoupe = Paths.get(fichierEnvoye.getSubmittedFileName()).getFileName().toString().split("\\.");
		System.out.println(nomFichierDecoupe.length);
		String nomFichier = UUID.randomUUID().toString() + "." + nomFichierDecoupe[nomFichierDecoupe.length-1];
		
		String dataDir = System.getProperty("jboss.server.data.dir") + "/paddlePics/";
		Path chemin = Paths.get(dataDir, "");
		if(!Files.exists(chemin)) {
			Files.createDirectories(chemin);
		}
		
		fichierSauvegarde = new File(dataDir, nomFichier);
		InputStream input = fichierEnvoye.getInputStream();
		System.out.println(fichierSauvegarde.getAbsolutePath());
		Files.copy(input, fichierSauvegarde.toPath());
		return dataDir+nomFichier;
	}
	
	//public static void remplacerImage(Part fichierEnvoye)
	
	

}
