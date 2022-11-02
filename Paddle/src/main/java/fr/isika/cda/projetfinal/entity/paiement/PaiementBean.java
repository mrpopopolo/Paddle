package fr.isika.cda.projetfinal.entity.paiement;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import fr.isika.cda.projetfinal.entity.user.UtilisateurRepository;
	@ManagedBean
	@Singleton
	@Startup
public class PaiementBean {

		@Inject
		private PaiementRepository repository;

		private String msg;

		@PostConstruct
		private void init() {
			msg = "Paiement est prêt";
			repository.initData();

		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}
	}


