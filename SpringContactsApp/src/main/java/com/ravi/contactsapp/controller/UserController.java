package com.ravi.contactsapp.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ravi.contactsapp.command.LoginCommand;
import com.ravi.contactsapp.command.UserCommand;
import com.ravi.contactsapp.domain.User;
import com.ravi.contactsapp.exception.UserBlockedException;
import com.ravi.contactsapp.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/index", "/" })
	public String index(Model model) {
		LoginCommand loginCommand = new LoginCommand();
		model.addAttribute("loginCommand", loginCommand);
		return "index"; // JSP /WEB-INF/jsps/index.jsp
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String checkLoginDetails(@ModelAttribute("loginCommand") LoginCommand loginCommand, Model m,
			HttpSession session) {

		try {
			User loggedInUser = userService.logIn(loginCommand.getEmail(), loginCommand.getPassword());

			if (loggedInUser != null) {
				m.addAttribute("loggedInUser", loggedInUser);
				addUserInSession(loggedInUser, session);
				if (loggedInUser.getRole().equals(userService.ROLE_USER))
					return "redirect:/user/dashboard_user";
				else
					return "redirect:/admin/dashboard_admin";

			} else {
				m.addAttribute("err", "Login Failed! Enter valid credentials!!");
				return "index";
			}
		} catch (UserBlockedException e) {

			// add error message and go back to index
			m.addAttribute("err", e.getMessage());
			return "index";
		}

	}

	@RequestMapping(value = "/admin/dashboard_admin")
	public String adminDashboard() {
		// TODO: add user detail in session (assign session to logged in user)
		return "dashboard_admin";
	}

	@RequestMapping(value = "/user/dashboard_user")
	public String userDashboard() {
		// TODO: add user detail in session (assign session to logged in user)
		return "dashboard_user";
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index?act=lo";
	}

	@RequestMapping(value = "/user/registrationForm")
	public String registrationForm(Model model) {
		UserCommand userCommand = new UserCommand();

		model.addAttribute("command", userCommand);

		return "registrationForm";
	}

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute("command") UserCommand userCommand, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			return "registrationForm";
		}

		try {

			User user = userCommand.getUser();
			user.setDob(new Date());
			user.setRole("user");
			user.setActive_yn("y");
			user.setLastLogin(new Date());

			if (!user.getPassword().equals(userCommand.getConfirmPassword())) {
				model.addAttribute("err", "Password & Confirm password are not same!!");
				return "registrationForm";
			}

			userService.register(user);

			return "redirect:/index?act=reg";

		} catch (DuplicateKeyException e) {

			model.addAttribute("err", e.getMessage());
			e.printStackTrace();
			return "registrationForm";
		}

	}

	@RequestMapping(value = "/user/userList")
	public String displayUserList(Model model, HttpSession session) {

		List<User> listUsers = null;

		if (session.getAttribute("role").equals(userService.ROLE_ADMIN)) {
			try {
				listUsers = userService.displayAllUsers();
			} catch (Exception e) {

				model.addAttribute("err", e.getMessage());
				e.printStackTrace();
				return "dashboard_admin";

			}

			model.addAttribute("listUsers", listUsers);

			return "user_list";

		}

		return "index";
	}

	@RequestMapping(value = "/user/searchText")
	public String searchUsers(@RequestParam("searchString") String searchString, HttpSession session, Model model) {
		List<User> listUsers = null;

		if (session.getAttribute("role").equals(userService.ROLE_ADMIN)) {
			try {
				listUsers = userService.searchUsers(searchString);
			} catch (Exception e) {

				model.addAttribute("err", e.getMessage());
				e.printStackTrace();
				return "user_list";

			}

			model.addAttribute("listUsers", listUsers);

			return "user_list";

		}

		return "index";

	}

	@RequestMapping(value = "/user/bulk_userBlock")
	public String actionSelectedUsers(@RequestParam(value = "uid",required=false) Integer[] userIds,
			@RequestParam("action_users") String actionUsers, HttpSession session, Model model) {

		if (userIds == null) {
			//model.addAttribute("err", "Please select userIds to perform action!");
			return "redirect:/user/userList?act=exp";
		}

		if (session.getAttribute("role").equals(userService.ROLE_ADMIN)) {
			try {
				if (actionUsers.equals("delete")) {
					userService.deleteUsers(userIds);
					return "redirect:/user/userList?act=bd_s";
				}

				else if (actionUsers.equals("activate")) {

					userService.blockOrActivateUsers(userIds, UserService.LOGIN_STATUS_ACTIVE);
					return "redirect:/user/userList?act=ba_s";
				} else if (actionUsers.equals("block")) {

					userService.blockOrActivateUsers(userIds, UserService.LOGIN_STATUS_BLOCK);
					return "redirect:/user/userList?act=bb_s";
				}
			} catch (Exception e) {
				model.addAttribute("err", e.getMessage());
				e.printStackTrace();
				return "user_list";

			}

		} else
			model.addAttribute("err", "Not a valid user.");

		return "index";

	}

	private void addUserInSession(User u, HttpSession session) {
		session.setAttribute("user", u);
		session.setAttribute("userId", u.getUserId());
		session.setAttribute("role", u.getRole());
	}

}
