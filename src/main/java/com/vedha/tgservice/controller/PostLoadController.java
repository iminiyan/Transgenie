package com.vedha.tgservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vedha.tech.common.constants.ActionMode;
import com.vedha.tech.common.controller.BasicController;
import com.vedha.tgservice.dto.PostLoadDTO;
import com.vedha.tgservice.exception.ApplicationException;
import com.vedha.tgservice.exception.ValidationException;
import com.vedha.tgservice.service.PostLoadService;
import com.vedha.tgservice.validator.PostLoadValidator;

import lombok.extern.log4j.Log4j;


@Log4j
@RestController
@RequestMapping("/postload")
public class PostLoadController extends BasicController{

		
	@Autowired
	PostLoadService postloadService;
	
	@Autowired
	@Qualifier("postloadValidator")
	private PostLoadValidator plvalidator;
	
	@InitBinder("postloadDTO")
	@Override
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(plvalidator);	
	}
	
	@Override
	@ModelAttribute("postloadDTO")
	protected PostLoadDTO createNewModel() {
		return new PostLoadDTO();
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public PostLoadDTO addPostLoad(@RequestBody PostLoadDTO dto, BindingResult bindingResult) throws ValidationException, ApplicationException {
		log.info("Trying to insert....");
		plvalidator.validate(dto, bindingResult);
		fillDefaultValue(dto, ActionMode.CREATE);
		if (bindingResult.hasErrors()) {
			throw new ValidationException(bindingResult);
		}
		else{
			return postloadService.savePostLoad(dto);
		}
	}
	
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public PostLoadDTO modifyPostLoad(@RequestBody PostLoadDTO dto) throws ApplicationException {
		log.info("Modify PostLoad");
		fillDefaultValue(dto, ActionMode.MODIFY);
		return postloadService.updatePostLoad(dto);
	}
	
		
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void deletePostLoad(@PathVariable("id") long id) throws ApplicationException {
		log.info("Delete PostLoad");
		postloadService.deletePostLoad(id);
	}
	
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<PostLoadDTO> getAllPostLoad() throws ApplicationException {
		log.info("Get All PostLoad");
		return postloadService.getAllPostLoad();
	}
	
	
	@RequestMapping(value = "/getByID/{id}", method = RequestMethod.GET)
	public PostLoadDTO getPostLoadByID(@PathVariable("id") long id) throws ApplicationException {
		log.info("Get PostLoad By ID");
		return postloadService.getPostLoadById(id);
	}
	
	
}
