package br.com.crown.eventoProgramado;

import java.math.BigDecimal;

import br.com.sankhya.extensions.eventoprogramavel.EventoProgramavelJava;
import br.com.sankhya.jape.EntityFacade;
import br.com.sankhya.jape.PersistenceException;
import br.com.sankhya.jape.bmp.PersistentLocalEntity;
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
 * Apliacação: Atualizar Numero do endereço do parceiro.
 */
public class AtualizaNumeroEnderecoEventoProgramado implements EventoProgramavelJava{

	@Override
	public void afterDelete(PersistenceEvent event) throws Exception {
		
	}

	@Override
	public void afterInsert(PersistenceEvent event) throws Exception {
		
	}

	@Override
	public void afterUpdate(PersistenceEvent event) throws Exception {
		
		DynamicVO parceiroVO = (DynamicVO)event.getVo();
		
		BigDecimal codParceiro = parceiroVO.asBigDecimal("CODPARC");
		
		AtualizaNumeroEndereco(codParceiro);

	}
	
	
	@Override
	public void beforeDelete(PersistenceEvent event) throws Exception {
		

	}

	@Override
	public void beforeInsert(PersistenceEvent event) throws Exception {
		
	}

	@Override
	public void beforeUpdate(PersistenceEvent event) throws Exception {
			
//		DynamicVO parceiroVO = (DynamicVO)event.getVo();
//		
//		BigDecimal codParceiro = parceiroVO.asBigDecimal("CODPARC");
//		
//		parceiroVO.setProperty("NUMEND", codParceiro.toString());
//		
	}
	
	@Override
	public void beforeCommit(TransactionContext tranCtx) throws Exception {
		
	}
	
	private void AtualizaNumeroEndereco(BigDecimal codParceiro) throws Exception, PersistenceException {
		SessionHandle hnd = null;
		
		try {
			hnd  = JapeSession.open();
			EntityFacade dwfFacade = EntityFacadeFactory.getDWFFacade();
			PersistentLocalEntity cidadeEntity = dwfFacade.findEntityByPrimaryKey("Parceiro", new Object[] {codParceiro});
			EntityVO entityVO = cidadeEntity.getValueObject();
			DynamicVO parcVO = (DynamicVO) entityVO;
			
			parcVO.setProperty("NUMEND", "123456");
				
			cidadeEntity.setValueObject((EntityVO) parcVO);
			
		}finally {
			
			JapeSession.close(hnd);
		}
	}

}
