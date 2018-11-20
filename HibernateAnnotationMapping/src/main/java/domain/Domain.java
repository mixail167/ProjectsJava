package domain;

import bl.HibernateUtil;
import entity.Address;
import entity.Employee;
import entity.Project;
import service.AddressService;
import service.EmployeeService;
import service.ProjectService;

import javax.persistence.EntityNotFoundException;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Domain {

    public static void main(String[] args) {
        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();

        Address address = new Address();
        address.setCountry("DC");
        address.setCity("Gotham city");
        address.setStreet("Arkham street 1");
        address.setPostCode("12345");

        Project project = new Project();
        project.setTitle("Gotham PD");

        Employee employee = new Employee();
        employee.setFirstName("James");
        employee.setLastName("Gordon");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1939, Calendar.MAY, 1);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Set<Employee> employees = new HashSet<Employee>();
        employees.add(employee);
        project.setEmployees(employees);
        address.setEmployees(employees);

        Set<Project> projects = new HashSet<Project>();
        projects.add(project);
        employee.setProjects(projects);

        addressService.add(address);
        employeeService.add(employee);
        projectService.add(project);

        List<Address> addressList = addressService.getAll();
        for (Address item : addressList) {
            System.out.println(item.toString());
        }
        List<Employee> employeeList = employeeService.getAll();
        for (Employee item : employeeList) {
            System.out.println(item.toString());
        }
        List<Project> projectList = projectService.getAll();
        for (Project item : projectList) {
            System.out.println(item.toString());
        }

        addressService.update(address);
        employeeService.update(employee);
        projectService.update(project);

        address = addressService.getById(address.getId());
        employee = employeeService.getById(employee.getId());
        project = projectService.getById(project.getId());

        addressService.remove(address);
        try {
            employeeService.remove(employee);
        } catch (EntityNotFoundException ignored) {

        }
        try {
            projectService.remove(project);
        } catch (EntityNotFoundException ignored) {

        }
        HibernateUtil.shutdown();
    }

}
