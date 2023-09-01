package br.com.crown.eventoProgramado;

import br.com.sankhya.extensions.eventoprogramavel.EventoProgramavelJava;
import br.com.sankhya.jape.event.PersistenceEvent;
import br.com.sankhya.jape.event.TransactionContext;


/*
 * Author: Jader
 * Tabela: TGFPAR
 * Tipo Rotina: Evento Programado
 * Apliacação:  trabalhar com todos os metodos da classe do evento progamvel
 */
public class ExemploEventoProgramado implements EventoProgramavelJava{

	@Override
	public void afterDelete(PersistenceEvent event) throws Exception {
		
		throw new Exception("Chamado metodo: Aftaer Delete");
	}

	@Override
	public void afterInsert(PersistenceEvent event) throws Exception {
		
		throw new Exception("Chamado metodo: Aftaer Inset");
	}

	@Override
	public void afterUpdate(PersistenceEvent event) throws Exception {
		
		throw new Exception("Chamado metodo: Aftaer Update");

	}
	
	@Override
	public void beforeDelete(PersistenceEvent event) throws Exception {
		
		throw new Exception("Chamado metodo:Before Delete");

	}

	@Override
	public void beforeInsert(PersistenceEvent event) throws Exception {
		
	//	throw new Exception("Chamado metodo:Before Insert");
	}

	@Override
	public void beforeUpdate(PersistenceEvent event) throws Exception {
		
		throw new Exception("Chamado metodo:Before Update");
	}
	
	@Override
	public void beforeCommit(TransactionContext tranCtx) throws Exception {
		
		
	}

}
