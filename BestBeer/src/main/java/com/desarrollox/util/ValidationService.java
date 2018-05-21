package com.desarrollox.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;


/**
 * Classe de servico para validações e etc
 * Utilizando o Desing Pattern SINGLETON
 * @author nrdossantos
 *
 */
public final class ValidationService {
	
	private static final Logger logger = Logger.getLogger(ValidationService.class); 
	
	private	static ValidationService instance;
	
	//Construtor privado
	private ValidationService() {
		
	}
	
	
	/**
	 * Metodo responsavel por validar o E-Mail
	 * @param email a ser validado
	 * @return true se valido, false caso contrario
	 */
	public boolean isValidEmail(String email) {
		logger.info("Iniciando a validacao do E-mail: " + email);
	    Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$"); 
	    Matcher m = p.matcher(email); 
	    if (m.find()){
	    	logger.info("O E-mail: " + email + " é valido" );
	      return true;
	    }
	    else{
	    	logger.info("O E-mail: " + email + " é invalido" );
	      return false;
	    }  
	 }
	
	
	public static synchronized ValidationService getInstance() {
		if(instance == null) {
			instance = new ValidationService();
		}
		return instance;
	}

}
