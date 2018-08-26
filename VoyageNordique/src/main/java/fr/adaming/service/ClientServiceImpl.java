package fr.adaming.service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import fr.adaming.Dao.IClientDao;
import fr.adaming.model.Client;

@Service("clService")
@Transactional
public class ClientServiceImpl implements IClientService{

//**************************************************************
	/**Transformation de l'asso UML en JAVA*/
	@Autowired
	private IClientDao clientDao;
	/**Le setter pour l'injection dependance*/
	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}
//*****************************************************************
	//***********$$$$$$$$$$$$$$$$$$***************************************
	@Override
	public Client addClientService(Client cl) {
		Random random = new Random();
		String randomString = random.toString();
		cl.setNoClient(randomString);
		return clientDao.addClient(cl);
	}
	//***********$$$$$$$$$$$$$$$$$$*********************************
	@Override
	public List<Client> getAllClientService() {
		// TODO Auto-generated method stub
		return clientDao.getAllClientDao();
	}
	//***********$$$$$$$$$$$$$$$$$$**********************************
	@Override
	public int updateClient(Client cl) {
		Random random = new Random();
		String randomString = random.toString();
		cl.setNoClient(randomString);
		return clientDao.updateClient(cl);
	}
	//***********$$$$$$$$$$$$$$$$$$***************************************
	@Override
	public int deleteClient(Client cl) {
		// TODO Auto-generated method stub
		return clientDao.deleteClient(cl);
	}
	//***********$$$$$$$$$$$$$$$$$$***************************************
	@Override
	public List<Client> getClientByNomOrNoClient(Client cl) {
		// TODO Auto-generated method stub
		return clientDao.getClientByNomOrNoClient(cl);
	}
	@Override
	public void sendMail(Client cl) {
		// mon compte gmail (pour recevoir les mail avec pdf)
		
		final String username="demba.sarrdiop1@gmail.com";
		final String password="Demba1989";
		//Les proprietés du mail
		Properties props=new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		// La recuperation d'une session
		
		Session session=Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(username, password);
			}
		});
		try{
			//La creation de l'objet Message par MimeMessage
			Message message=new MimeMessage(session);
			//Passage du message au username
			message.setFrom(new InternetAddress(username));
			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(cl.getMail()));
			
			// Set Subject: header du message
			message.setSubject("Mail facture");
			
			ByteArrayOutputStream outputStream=null;
			
			//Partie 1: Le text
			MimeBodyPart mbp1=new MimeBodyPart();
			mbp1.setText("Cher(e) Client(e), " +" M.(me) " + cl.getNomClient() + "\n\n Merci de votre confiance!"
					+ "\n Votre inscription s'est bien effectuée sur notre site"
					+ "\n Votre identifiant est: "+ cl.getMail()
					+ "\n Votre Mot de passe est: "+ cl.getMdp()
					+ "\n\n\n L'equipe Demba, Noelia, Ewen et Thibault vous souhaite la bienvenue sur notre site!");
			
			//Ecrire le pdf dans outputStream
			outputStream =new ByteArrayOutputStream();
			
			//On regroupe les deux dans le message maitenant
			MimeMultipart mp=new MimeMultipart();
			mp.addBodyPart(mbp1);
			//mp.addBodyPart(pdfbp);
			message.setContent(mp);
			
			//On en voie le message
			Transport.send(message);
			//Verification de la reussite de l'envoie du mail
			System.out.println("DSD envoie du mail reussi ");
						
		}catch(Exception e){
			throw new RuntimeException(e);
		}		
	}
	@Override
	public Client getClientByMail(Client cl) {
		return clientDao.getClientByMail(cl);
	}

}
