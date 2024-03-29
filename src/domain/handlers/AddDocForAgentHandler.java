package domain.handlers;

import domain.interfaces.IAddDocForAgentHandler;

public class AddDocForAgentHandler implements IAddDocForAgentHandler {

	@Override
	public boolean giveAgentName(String codeName, String accessK) {
		System.out.println("AddDocForAgentHandler: giveAgentName(" + codeName + 
				", " + accessK + ")");
		return !codeName.equals("fail");
	}

	@Override
	public String giveDocumentName(String fileName) {
		System.out.println("AddDocForAgentHandler: giveDocumentName(" + fileName + ")");
		return "ToAg0";
	}
	
	@Override
	public void cancel() {
		System.out.println("AddDocForAgentHandler: cancel()");
	}

}
