package view;

public class Constants {

	public static final String MENU = "Menu.fxml";
	public static final String VIEW_CREATE_AGENT = "CreateAgent.fxml";
	public static final String VIEW_CREATE_MISSION = "CreateMission.fxml";
	public static final String VIEW_ADD_DOCUMENT_FOR_AGENT = "AddDocForAgent.fxml";
	public static final String VIEW_READ_DOCUMENT_FROM_AGENT = "ReadDocFromAgent.fxml";
	public static final String VIEW_AVAILABILITY_AGENT = "SetUnavailability.fxml";
	public static final String VIEW_SEARCH_AGENT = "SearchAgentInfo.fxml";
	public static final String VIEW_SEARCH_MISSION = "SearchMissionInfo.fxml";
	
	public static final String ERROR_AGENT_EXISTS = "Já existe um agente com esse nome de código";
	public static final String ERROR_CODENAME_EXISTS_RECOVERY = "Forneça um nome de código inexistente";
	public static final String ERROR_UNACCEPTED_ACCESSKEY = "Chave de acesso fraca";
	public static final String ERROR_UNACCEPTED_ACCESSKEY_RECOVERY = "Escolha uma chave mais forte, ou mude de verificador de chave";
	
	public static final String ERROR_MISSION_EXISTS = "Já existe uma missão com esse nome de código";
	public static final String ERROR_RESPONSIBLE_ACCESS_FAIL = "Código ou chave do responsável inválidos";
	public static final String ERROR_ACCESS_FAIL_RECOVERY = "Verifique os seus dados de acesso, e tente de novo";
	public static final String ERROR_ACCESS_FAIL = "Código inexistente, chave inválida, ou não tem permissão de acesso";
	
	public static final String ERROR_DIALOG_TITLE = "Erro";
	public static final String INFO_DIALOG_TITLE = "Sucesso"; 
	public static final String LOGIN_INVALID_USERNAME = "Preencha o código de utilizador";
	public static final String LOGIN_INVALID_PASSWORD = "Preencha a chave";
	public static final String LOGIN_FAIL = "Código ou chave inválidos";
	public static final String USE_CASE_PRECONDITION_ERROR = "Não há nenhum utilizador autenticado na aplicação";
	public static final String USE_CASE_PRECONDITION_RECOVERY = "Autentique-se na aplicação para a poder utilizar";
	
}
