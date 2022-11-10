package fr.isika.cda.projetfinal.tools;

import java.io.IOException;
import java.util.Base64;
import javax.servlet.http.Part;

public class OutilsImage {

	public static String sauvegarderImage(Part fichierEnvoye) throws IOException {
		return "data:image/png;base64,"+ Base64.getEncoder().encodeToString(fichierEnvoye.getInputStream().readAllBytes());
	}


}
