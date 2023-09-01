package br.com.crown.simuladorErro;

import br.com.sankhya.extensions.actionbutton.AcaoRotinaJava;
import br.com.sankhya.extensions.actionbutton.ContextoAcao;

public class SimuladorErroBotaoAcao implements AcaoRotinaJava {

	@Override
	public void doAction(ContextoAcao contexto) throws Exception {
		
		String senha = (String)contexto.getParam("SENHA");
		
		if (senha.equals("cursojava")) {
			
			contexto.setMensagemRetorno("Senha Valida, Acesso Liberado!!");			
		}else {
			
			contexto.setMensagemRetorno("Senha invalida, Acesso Negado!!");
		}
	
	}

}
