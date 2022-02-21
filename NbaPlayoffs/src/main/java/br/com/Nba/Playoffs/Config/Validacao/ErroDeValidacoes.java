package br.com.Nba.Playoffs.Config.Validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.Nba.Playoffs.Config.Validacao.dto.ErroNbaDTO;

@RestControllerAdvice
public class ErroDeValidacoes {
	
	@Autowired
	private MessageSource message;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroNbaDTO> TratarErro(MethodArgumentNotValidException exception) {
		List<ErroNbaDTO>dto = new ArrayList<>();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e -> {
			String mensagem = message.getMessage(e, LocaleContextHolder.getLocale());
			ErroNbaDTO erro = new ErroNbaDTO(e.getField(), mensagem);
			dto.add(erro);
		});
		return dto;
	}
	
}
