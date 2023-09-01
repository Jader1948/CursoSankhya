package br.com.crown.estudoBotaoAcao;

import java.math.BigDecimal;



import br.com.sankhya.extensions.actionbutton.AcaoRotinaJava;
import br.com.sankhya.extensions.actionbutton.ContextoAcao;
import br.com.sankhya.extensions.actionbutton.Registro;
import br.com.sankhya.jape.EntityFacade;
import br.com.sankhya.jape.bmp.PersistentLocalEntity;
import br.com.sankhya.jape.core.JapeSession;
import br.com.sankhya.jape.core.JapeSession.SessionHandle;
import br.com.sankhya.jape.vo.DynamicVO;
import br.com.sankhya.jape.vo.EntityVO;
import br.com.sankhya.modelcore.util.EntityFacadeFactory;

public class EstudoBotaoAcao implements AcaoRotinaJava {

	@Override
	public void doAction(ContextoAcao contexto) throws Exception {

	BigDecimal populcao = BigDecimal.valueOf( ((Integer)contexto.getParam("POPULACAO")).intValue() );
	
	String novoNome = (String) contexto.getParam("NOVONOME");
	
	BigDecimal codRegiao = new BigDecimal ( (String)contexto.getParam("CODREGIAO"));
	
	Registro [] registros = contexto.getLinhas();
	
	for(Registro registro : registros) {
		
		BigDecimal codCidade = (BigDecimal)registro.getCampo("CODCID");
		
		atualizarRegistroSelecionado(codCidade, codRegiao, novoNome, populcao);		
		
		}
		
		contexto.setMensagemRetorno("Registros Atualizados com Sucesso!!");
	
	}

	private void atualizarRegistroSelecionado(BigDecimal codCidade, BigDecimal codRegiao, String novoNome,
			BigDecimal populcao) throws Exception {
		
		SessionHandle hnd = null;
		
		try {
			hnd  = JapeSession.open();
			EntityFacade dwfFacade = EntityFacadeFactory.getDWFFacade();
			PersistentLocalEntity cidadeEntity = dwfFacade.findEntityByPrimaryKey("Cidade", new Object[] {codCidade});
			EntityVO entityVO = cidadeEntity.getValueObject();
			DynamicVO cidadeVO = (DynamicVO) entityVO;
			
			cidadeVO.setProperty("NOMECID", novoNome);
			cidadeVO.setProperty("CODREG", codRegiao);
			cidadeVO.setProperty("POPULACAO", populcao);
			
			cidadeEntity.setValueObject((EntityVO) cidadeVO);
			
		}finally {
			
			JapeSession.close(hnd);
		}
		
	}

}
