package com.desarrollox.tx;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Transacional
@Interceptor
public class TransactionManager {
	

		/**
		 * 
		 */
		private static final long serialVersionUID = 3385987300028727780L;
		@Inject
		EntityManager manager;
		
		/*
		 * InvocationContext: o CDI deve passar o contexto de invocação, o metodo que deve ser chamado
		 * para realizar a transacao (gravar... remover..)
		 * 
		 * AroundInvoke: Indica ao CDI que esse metodo deve ser invocado "ao redor" de uma transação. 
		 */
		@AroundInvoke
		public Object executaTx(InvocationContext context) throws Exception {

			// abre transacao
			manager.getTransaction().begin();
			
			Object result = context.proceed();

			// commita a transacao
			manager.getTransaction().commit();
			
			return result;
		}

}
