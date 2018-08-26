package fr.adaming.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.OffreVoyage;
import fr.adaming.model.Panier;
import fr.adaming.service.IOffreVoyageService;
import fr.adaming.service.IPanierService;

@SuppressWarnings("serial")
@Controller
@RequestMapping("/panier")
@Scope("session")
@SessionAttributes(value = "visiteur")
public class PanierController implements Serializable {

	@Autowired
	private IPanierService panierService;

	// Setter pour l'injection d�pendance
	public void setPanierService(IPanierService panierService) {
		this.panierService = panierService;
	}

	@Autowired
	private IOffreVoyageService offreService;

	// Setter pour l'injection d�pendance
	public void setOffreService(IOffreVoyageService offreService) {
		this.offreService = offreService;
	}

	/**
	 * Les attributs
	 */
	private Panier panier;
	private OffreVoyage offre;
	private int quantite;
	private LigneCommande ligneCommande;
	private List<LigneCommande> listePanier = new ArrayList<>();
	private double prixTotal;

	/**
	 * Constructeur vide
	 */
	public PanierController() {
		super();
		this.panier = new Panier();
		this.offre = new OffreVoyage();
		this.ligneCommande = new LigneCommande();
	}

	@PostConstruct
	@ModelAttribute(value = "visiteur")
	public void init() {

		// on r�cupere la session du panier et on verifie qu'elle ne soit pas
		// vide
		if (panier != null) {

			// on recupere la liste de commande du panier et on verifie qu'elle
			// ne soit pas vide
			if (panier.getListeCommande() != null) {

				// on stocke la nouvelle liste dans la nouvelle
				for (LigneCommande lc : panier.getListeCommande()) {
					if (lc.getQuantite() != 0) {
						this.listePanier.add(lc);

					}

					System.out.println(this.prixTotal);

					// calcul du prix total de la commande
					this.prixTotal = panierService.calculTotalPanier(panier.getListeCommande());
					System.out.println(this.prixTotal);
				}

			}
		}
	}

	// declaration des getters et setters
	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier pan) {
		this.panier = pan;
	}

	public OffreVoyage getOffre() {
		return offre;
	}

	public void setProduit(OffreVoyage ov) {
		this.offre = ov;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public LigneCommande getLigneCommande() {
		return ligneCommande;
	}

	public void setLigneCommande(LigneCommande lc) {
		this.ligneCommande = lc;
	}

	public List<LigneCommande> getListePanier() {
		return listePanier;
	}

	public void setListePanier(List<LigneCommande> listePanier) {
		this.listePanier = listePanier;
	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

	// ******************* recup de la liste du panier
	/**
	 * M�thode d'affichage de la liste du panier
	 * 
	 * @return modelAndView
	 */
	@RequestMapping(value = "/listePanier", method = RequestMethod.GET)
	public ModelAndView affichePanierListe() {

		return new ModelAndView("panierListe", "listePanier", listePanier);
	}

	/**
	 * Ajouter une offre dans son panier en passant par une ligne de commande.
	 * Ce panier n'est pas stock� dans la base de donn�e mais dans la session.
	 */
	@RequestMapping(value = "/addOffrePan", method = RequestMethod.GET)
	public String addOffrePanier(Model modele, @RequestParam(value = "error", required = false) String error) {

		if (error != null) {
			modele.addAttribute("error", error);
		}

		modele.addAttribute("panAjout", new Panier());

		return "panierAjout";
	}

	@RequestMapping(value = "/soummettreAddOffrePan", method = RequestMethod.POST)
	public String soummettreAddOffrePanier(Model modele, @RequestParam(value = "error", required = false) String error,
			@RequestParam("pName") String designation, RedirectAttributes rda) {

		// le panier dans la session est r�cup�rer dans le postConstruct
		
		// on r�cupere le voyage de la base de donn�e.
		OffreVoyage ovOut = offreService.getOffreVoyageByName(this.offre);

		// on v�rifie que le voyage existe
		if (ovOut != null) {

			// cr�ation d'un indice en int dont la valeur sera modifi� � 1 si le
			// voyage �tait d�j� pr�sent dans le panier, sinon, il reste � z�ro
			// pour faire la cr�ation d'une ligne de commande
			int verifAjoutPanier = 0;

			// on verifie que le panier a d�j� des entr�es, sinon, on ajoute
			// directement une ligne de commande dedans
			if (this.listePanier.size() > 0) {

				for (LigneCommande lc : listePanier) {
					// Pour chaque ligne de commande, on v�rifie si le voyage
					// n'est pas d�j� pr�sent dans le panier, en v�rifiant si
					// l'id du voyage correspond � l'id du voyage dans la
					// ligne de commande
					if (lc.getOffrevoyage().getIdVoyage() == ovOut.getIdVoyage()) {

						// si l'id est identique, on v�rifie que la quantit�
						// d�j�
						// command� + la quantit� rajout� sont inf�rieur au
						// stock
						// disponible de produit

						if ((this.quantite + lc.getQuantite()) <= ovOut.getQuantite()) {

							lc.setQuantite(lc.getQuantite() + this.quantite);
							lc.setPrix(lc.getPrix() + (this.quantite * ovOut.getPrixVoyage()));

							// on passe l'indice � 1 vu que le voyage a �t�
							// ajout� dans une ligne d�j� existante
							verifAjoutPanier = 1;

							// on ajoute au panier la liste de commande
							panier.setListeCommande(this.listePanier);

							// pour calculer le prix total de la commande
							this.prixTotal = panierService.calculTotalPanier(panier.getListeCommande());

							return "panierListe";

						} else {
							// Message d'erreur suite � la tentative d'ajout de
							// produit
							// au panier :"Il n'y a plus de place pour ce
							// voyage"
							rda.addAttribute("error", true);
							return "panierListe";
						}

					}

				}

			}

			// si l'indice verifAjoutPanier est � 0, c'est que le voyage
			// n'existait pas dans le panier et qu'il n'a pas �t� ajout�
			if (verifAjoutPanier == 0) {

				// Cr�ation d'une ligne de commande
				LigneCommande lcOut = panierService.addVoyagePanier(ovOut, this.quantite);

				// v�rification que la ligne de commande a �t� cr��e
				if (lcOut != null) {

					// on ajoute � la liste de ligne de commande cette nouvelle
					// nouvelle ligne de commande
					this.listePanier.add(lcOut);

					// on ajoute au panier la liste de commande
					panier.setListeCommande(this.listePanier);

					// pour calculer le prix total de la commande
					this.prixTotal = panierService.calculTotalPanier(panier.getListeCommande());

					return "panierListe";

				} else {

					// Message d'erreur suite � la tentative d'ajout de produit
					// au panier :"Il n'y a plus de place pour ce voyage"
					rda.addAttribute("error", true);
				}

			} else {
				// Message d'erreur suite � la tentative d'ajout de produit
				// au panier :"Une erreur s'est produite"
				rda.addAttribute("error", true);
			}

		} else

		{
			// Message d'erreur suite � la tentative d'ajout de produit
			// au panier :"Le voyage n'existe pas dans la base de donn�e"
			rda.addAttribute("error", true);
		}
		modele.addAttribute("afficherPanier", listePanier);
		return "panierListe";
	}

	public String ajoutOffrePanierDirect() {

		panierService.addVoyagePanierDirect(this.ligneCommande, this.quantite);

		// on ajoute au panier la liste de commande
		panier.setListeCommande(this.listePanier);

		// pour calculer le prix total de la commande
		this.prixTotal = panierService.calculTotalPanier(panier.getListeCommande());

		return "panierListe";
	}

	public String supprOffrePanierDirect() {

		if (this.ligneCommande.getQuantite() > 0) {
			panierService.supprProdPanierDirect(this.ligneCommande, this.quantite);

			// permet de supprimer la ligne si la quantit� est � 0
			if (this.ligneCommande.getQuantite() == 0) {
				this.listePanier.remove(this.ligneCommande);

			}

			// on ajoute au panier la liste de commande
			panier.setListeCommande(this.listePanier);

			// pour calculer le prix total de la commande
			this.prixTotal = panierService.calculTotalPanier(panier.getListeCommande());

		}

		return "panierListe";
	}

}
