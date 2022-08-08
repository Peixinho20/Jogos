package regras;

import java.util.Map;
import javax.swing.JButton;

public class ControleBotoesSelecionados{
	
	private String nmBotao;
	private Map<JButton, Boolean> referenciaBotoes; //Ja da pra saber se o botao esta selecioando ou nao
	
	// Controles de um botão:
	
	public ControleBotoesSelecionados() {
		this.referencia = new HashMap<JButton, Boolean>(); //Use Hash...<>, depende da versao do java
	}
	
	public String getNmBotao() {
		return nmBotao;
	}
	
	public void setNmBotao(String nmBotao) {
		this.nmBotao = nmBotao;
	}
	
	public Map<JButton, Boolean> getReferenciaBotoes() {
		return referenciaBotoes;
	}
	
	public void setReferenciaBotoes (Map<JButton, Boolean> refenciaBotoes) {
		this.referenciaBotoes = referenciaBotoes;
	}
	
	public void adicionarBotoao(JButton botao) {
		this.referenciaBotoes.put(botao, Boolean.False); //botao ainda não selecionado
	}
	
	public void alterarSelecao(JButton botao, Boolean selecionado){
		Boolean b = this.referenciaBotoes.get(botao);
		b = selecionado;
	}
	
	public void zerarSelecoes() {
		this.referenciaBotoes.values().stream().forEach((b) -> {
		b = false;
		});
	}
	
	public Boolean isTodasSelecionadas() {
		for (Boolean b : this.referenciaBotoes.values()) {
			if (!b) {
				//Não foram todos selecionados
				return false;
			}
		}
		return true;
	}
	
}











