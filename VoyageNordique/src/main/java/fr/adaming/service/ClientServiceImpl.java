package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	//***********$$$$$$$$$$$$$$$$$$**************
	@Override
	public Client addClientService(Client cl) {
		// TODO Auto-generated method stub
		return clientDao.addClient(cl);
	}
	//***********$$$$$$$$$$$$$$$$$$**************
	@Override
	public List<Client> getAllClientService() {
		// TODO Auto-generated method stub
		return clientDao.getAllClientDao();
	}

}
