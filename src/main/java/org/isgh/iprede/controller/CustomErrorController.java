package org.isgh.iprede.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.isgh.iprede.exception.RestException;
import org.isgh.iprede.exception.RestExceptionCode;
import org.isgh.iprede.model.response.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

public class CustomErrorController implements ErrorController {

	private static final String PATH = "/error";

    @Autowired
    private ErrorAttributes errorAttributes;
	
	@Override
	public String getErrorPath() {
		return PATH;
	}
	
	@RequestMapping(value = PATH)
    public ErrorResponse error(HttpServletRequest request, HttpServletResponse response) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        Throwable t = this.errorAttributes.getError(requestAttributes);

        if (t instanceof RestException) {
            RestException mre = (RestException) t;
            response.setStatus(mre.getHttpStatus().value());
            return new ErrorResponse(mre);
        }
        
        response.setStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        return new ErrorResponse(RestExceptionCode.FC_RE_001, t.getMessage());
    }

}
