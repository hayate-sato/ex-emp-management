package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.form.UpdateEmployeeForm;
import jp.co.sample.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeServise;

	@RequestMapping("/showList")
	public String showList(Model model) {

		List<Employee> employeeList = employeeServise.showList();

		model.addAttribute("employeeList", employeeList);

		return "employee/list";
	}

	@ModelAttribute
	public UpdateEmployeeForm setUpdateEmployeeForm() {
		return new UpdateEmployeeForm();
	}

	@RequestMapping("/showDetail")
	public String showDetail(String id, Model model) {

		Employee employee = employeeServise.showDetail(Integer.parseInt(id));

		model.addAttribute("employee", employee);
		return "employee/detail";
	}

	@RequestMapping("/update")
	public String update(UpdateEmployeeForm form) {

		int idInt = Integer.parseInt(form.getId());
		Employee employee = employeeServise.showDetail(idInt);

		int dependentsInt = Integer.parseInt(form.getDependentsCount());
		employee.setDependentsCount(dependentsInt);

		employeeServise.update(employee);
		return "redirect:/employee/showList";
	}
}
