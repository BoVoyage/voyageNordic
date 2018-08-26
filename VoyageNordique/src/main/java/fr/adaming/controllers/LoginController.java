package fr.adaming.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.model.Client;

@Controller
public class LoginController {

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String afficheFormLogin(@ModelAttribute("user") Client cl,HttpSession session){
		session.setAttribute("Client-Entity", cl);
		return "loginPage";
	}
	
	//M�thode dans le cas d'un acc�s refus�
	@RequestMapping(value="/denied",method=RequestMethod.GET)
	public String afficheDenied(){
		return "deniedPage";
	}
	
	//M�thode appel�e lors de l'�chec de l'authentification
	@RequestMapping(value="/echec",method=RequestMethod.GET)
	public String afficheEchec(ModelMap modele){
		modele.addAttribute("echec", true);
		return "loginPage";
	}
	
	//M�thode appel�e lors de la d�connexion
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String afficheLogout(Model modele){
		modele.addAttribute("msg", true);
		return "loginPage";
	}
	
}
