package br.com.crown.sankhya.InseContatoParceiro;

import java.math.BigDecimal;

import br.com.sankhya.extensions.eventoprogramavel.EventoProgramavelJava;
import br.com.sankhya.jape.EntityFacade;
import br.com.sankhya.jape.core.JapeSession;
import br.com.sankhya.jape.core.JapeSession.SessionHandle;
import br.com.sankhya.jape.event.PersistenceEvent;
import br.com.sankhya.jape.event.TransactionContext;
import br.com.sankhya.jape.vo.DynamicVO;
import br.com.sankhya.jape.vo.EntityVO;
import br.com.sankhya.modelcore.util.EntityFacadeFactory;


/*
 * Author: Jader
 * Tabela: TGFPAR
 * Tipo Rotina: Evento Programado
 * Apliacação: Cria um Contato para novos parceiros caso seja Pessoa fisica
 */



public class insereContatoParceiro implements EventoProgramavelJava{

	@Override
	public void afterDelete(PersistenceEvent event) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterInsert(PersistenceEvent event) throws Exception {

		DynamicVO parcVo = (DynamicVO)event.getVo();
		
		String nomeParceiro = parcVo.asString("NOMEPARC");
		
		BigDecimal codParceiro = parcVo.asBigDecimal("CODPARC");
		
		String tipPessoa = parcVo.asString("TIPPESSOA");
		
				
		if("F".equals(tipPessoa)) {
			
			insertParceiro(nomeParceiro, codParceiro);
			
		}		
				
	}

	@Override
	public void afterUpdate(PersistenceEvent event) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeCommit(TransactionContext tranCtx) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeDelete(PersistenceEvent event) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeInsert(PersistenceEvent event) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeUpdate(PersistenceEvent event) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	private void insertParceiro(String nomeParceiro, BigDecimal codParc) throws Exception {
		
		SessionHandle hnd = null;
		
		
		try {
			hnd  = JapeSession.open();
			EntityFacade dwfFacade = EntityFacadeFactory.getDWFFacade();
			EntityVO entityVO = dwfFacade.getDefaultValueObjectInstance("Contato");
			DynamicVO dynamicVO = (DynamicVO) entityVO;
			
			dynamicVO.setProperty("NOMECONTATO", nomeParceiro);
			dynamicVO.setProperty("CODPARC", codParc);
			 
			dwfFacade.createEntity("Contato", entityVO);
			
						
		}finally {
			
			JapeSession.close(hnd);
		}
		
	}
	
}
