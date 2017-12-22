package org.isgh.iprede.exception;

import org.springframework.http.HttpStatus;

public enum RestExceptionCode {
	
	// warnings
    WC_FE_001(HttpStatus.METHOD_NOT_ALLOWED, "As estatísticas não podem ser exibidas para esta execução porque é uma corrida de simulação", false),
    WC_FE_008(HttpStatus.BAD_REQUEST, "A formatação do número do artigo não corresponde à especificação: valor positivo de 7 dígitos", false),
    // errors
	EC_FE_001(HttpStatus.UNAUTHORIZED, "Nome de usuário e/ou senha não conferem", false),
	EC_FE_002(HttpStatus.NOT_ACCEPTABLE, "O usuário já está logado", false),
	EC_FE_003(HttpStatus.SERVICE_UNAVAILABLE, "O aplicativo atualmente não está disponível", true),
	EC_FE_004(HttpStatus.NOT_FOUND, "O arquivo de log não pode ser acessado", false),
	EC_FE_005(HttpStatus.NOT_ACCEPTABLE, "A execução já foi lançada / rejeitada e já não está disponível como lançamento aberto", false),
	EC_FE_006(HttpStatus.UNAUTHORIZED, "Usuário sem permissão", true),
	EC_FE_014(HttpStatus.BAD_REQUEST, "A ID inserida não existe no contexto dos critérios de filtragem", false),
	EC_FE_016(HttpStatus.BAD_REQUEST, "Não há nenhum número de artigo inserido", false),
	EC_FE_017(HttpStatus.BAD_REQUEST, "Nem todos os campos são preenchidos com dados", false),
    EC_FE_023(HttpStatus.BAD_REQUEST, "O número do artigo já existe na lista negra HW", false),
    //EC_FE_024(HttpStatus.BAD_REQUEST, "Artikelnummer existiert in FV HW und kann daher nicht als Dummy gespeichert werden", false),
    //EC_FE_025(HttpStatus.BAD_REQUEST, "Dummy-Flag muss gesetzt werden oder Artikelno kann nicht gespeichert werden", false),
    // fatal errors
	FC_RE_001(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno", true);

    
    
    private HttpStatus httpStatus;
	private String error;
	private boolean logError;
	
	RestExceptionCode(HttpStatus httpStatus, String error, boolean logError) {
		this.httpStatus = httpStatus;
		this.error = error;
		this.logError = logError;
	}
	
	public static RestExceptionCode fromString(String code) {
		try {
			return RestExceptionCode.valueOf(code.trim().toUpperCase());
		} catch (NullPointerException ex) {
			return null;
		} catch (IllegalArgumentException ex) {
			return null;
		}
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	public String getError() {
		return error;
	}

	public boolean isLogError() {
		return logError;
	}

}
