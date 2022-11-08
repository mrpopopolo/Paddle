package fr.isika.cda.projetfinal.tools;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.ws.rs.core.Context;

public class OutilsImage {

	private static File fichierSauvegarde;

	public static String sauvegarderImage(Part fichierEnvoye) throws IOException {
		String[] nomFichierDecoupe = Paths.get(fichierEnvoye.getSubmittedFileName()).getFileName().toString().split("\\.");
		String nomFichier = UUID.randomUUID().toString() + "." + nomFichierDecoupe[nomFichierDecoupe.length-1];
		
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        Object requestObj = context.getRequest();
        HttpServletRequest request = (HttpServletRequest) requestObj;
		
		String dataDir = request.getSession().getServletContext().getRealPath("/resources/images");
		
		fichierSauvegarde = new File(dataDir, nomFichier);
		InputStream input = fichierEnvoye.getInputStream();
		Files.copy(input, fichierSauvegarde.toPath());
		return "resources/images/"+nomFichier;
	}
	
	public static void remplacerImage(Part fichierEnvoye, String cheminAncienFichier) throws IOException {
		Path cheminFichierEnvoye = Paths.get(fichierEnvoye.getSubmittedFileName()).getFileName();
		Path cheminEcrase = Paths.get(cheminAncienFichier, "");
		Files.copy(cheminFichierEnvoye, cheminEcrase, StandardCopyOption.REPLACE_EXISTING);
	}

}
