package org.test.task.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.test.task.model.Message;
import org.test.task.model.User;
import org.test.task.service.MessageService;
import org.test.task.service.UserService;
import org.test.task.validators.UserValidator;

import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {
	static final Logger logger = LoggerFactory.getLogger(AppController.class);


	@Autowired
	MessageService messageService;
	@Autowired
	UserService userService;
	@Autowired
	UserValidator userValidator;

	@RequestMapping(method = RequestMethod.GET)
	public String getIndexPage(ModelMap model) {
		List<Message> messages = messageService.findAllMessages();
		model.addAttribute("messages", messages);

		return "userMessages";
	}

	@RequestMapping(value = { "/newmessage" }, method = RequestMethod.GET)
	public String newMessage(ModelMap model) {
		Message message = new Message();
		model.addAttribute("message", message);
		model.addAttribute("edit", false);
		return "addNewMessage";
	}

	@RequestMapping(value = { "/newmessage" }, method = RequestMethod.POST)
	public String saveMessage(Message message, BindingResult result) {

		userValidator.validate(message.getRecipient(), result);

		if (result.hasErrors()) {
			return "addNewMessage";
		}

		String userName = message.getRecipient().getName();
		User user  = userService.findByName(userName);
		if (null == user){
			user = new User(userName);
			userService.save(user);
		}
		message.setRecipient(user);

		messageService.saveMessage(message);
		return "redirect:/";
	}

	@RequestMapping(value = { "/edit-msg-{id}" }, method = RequestMethod.GET)
	public String editMessage(@PathVariable int id, ModelMap model) {
		Message message = messageService.findById(id);
		String userName  = message.getRecipient().getName();
		message.setRecipient(new User(userName));
		model.addAttribute("message", message);
		model.addAttribute("edit", true);
		return "addNewMessage";
	}

	@RequestMapping(value = { "/edit-msg-{id}" }, method = RequestMethod.POST)
	public String updateMessage(Message message, BindingResult result) {

		userValidator.validate(message.getRecipient(), result);

		if (result.hasErrors()) {
			return "addNewMessage";
		}

		String userName = message.getRecipient().getName();
		User user  = userService.findByName(userName);
		if (null == user){
			user = new User(userName);
			userService.save(user);
		}
		message.setRecipient(user);

		messageService.updateMessage(message);
		return "redirect:/";
	}

}