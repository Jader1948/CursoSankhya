package br.com.crown.eventoProgramado;

import java.math.BigDecimal;

import br.com.sankhya.extensions.eventoprogramavel.EventoProgramavelJava;
import br.com.sankhya.jape.event.PersistenceEvent;
import br.com.sankhya.jape.event.TransactionContext;
import br.com.sankhya.jape.vo.DynamicVO;


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
		

	}
	
	@Override
	public void beforeDelete(PersistenceEvent event) throws Exception {
		

	}

	@Override
	public void beforeInsert(PersistenceEvent event) throws Exception {
		
	}

	@Override
	public void beforeUpdate(PersistenceEvent event) throws Exception {
			
		DynamicVO parceiroVO = (DynamicVO)event.getVo();
		
		BigDecimal codParceiro = parceiroVO.asBigDecimal("CODPARC");
		
		parceiroVO.setProperty("NUMEND", codParceiro.toString());
		
	}
	
	@Override
	public void beforeCommit(TransactionContext tranCtx) throws Exception {
		
		
	}

}
