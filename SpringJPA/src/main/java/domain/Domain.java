package domain;

import entity.Address;
import entity.Employee;
import entity.Project;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import repository.AddressRepository;
import repository.EmployeeRepository;
import repository.ProjectRepository;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Domain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AddressRepository addressRepository = context.getBean(AddressRepository.class);
        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
        ProjectRepository projectRepository = context.getBean(ProjectRepository.class);

        Address address = new Address();
        address.setId(1L);
        address.setCountry("DC");
        address.setCity("Gotham City");
        address.setStreet("Arkham street");
        address.setPostCode("12345");

        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("James");
        employee.setLastName("Gordon");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1939, Calendar.MAY, 1);
        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Project project = new Project();
        project.setId(1L);
        project.setTitle("Gotham City Police Department Commissioner");

        Set<Employee> employees = new HashSet<Employee>();
        employees.add(employee);
        project.setEmployees(employees);
        address.setEmployees(employees);

        Set<Project> projects = new HashSet<Project>();
        projects.add(project);
        employee.setProjects(projects);

        addressRepository.save(address);
        employeeRepository.save(employee);
        projectRepository.save(project);

        List<Employee> employeeList = employeeRepository.findAll();
        for (Employee item : employeeList) {
            System.out.println(item);
        }
        List<Address> addressList = addressRepository.findAll();
        for (Address item : addressList) {
            System.out.println(item);
        }
        List<Project> projectList = projectRepository.findAll();
        for (Project item : projectList) {
            System.out.println(item);
        }
        System.out.println(employeeRepository.findByFirstNameAndLastName("James", "Gordon"));
        addressRepository.delete(1L);
        if (employeeRepository.count() > 0)
            employeeRepository.delete(1L);
        if (projectRepository.count() > 0)
            projectRepository.delete(1L);
    }
}
