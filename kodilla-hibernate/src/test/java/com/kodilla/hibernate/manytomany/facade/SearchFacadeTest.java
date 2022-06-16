package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SearchFacadeTestSuite {

    @Autowired
    private SearchFacade searchFacade;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    Employee johnSmith = new Employee("John", "Smith");
    Company softwareMachine = new Company("Software Machine");

    @BeforeEach
    void beforeEveryTest() {
        softwareMachine.getEmployees().add(johnSmith);
        johnSmith.getCompanies().add(softwareMachine);
    }

    @Test
    void testFindCompanyByPartOfName() {
        try{
            //Given
            companyDao.save(softwareMachine);

            //When
            List<Company> companies = searchFacade.findCompanyByPartOfName("are");

            //Then
            assertEquals("Software Machine", companies.get(0).getName());
        } catch (SearchException e) {
            System.out.println(SearchException.ERR_COMPANY_NOT_EXIST);
        } finally {
            //CleanUp
            companyDao.deleteById(softwareMachine.getId());
        }
    }

    @Test
    void testFindEmployeeByPartOfName() {
        try {
            //Given
            employeeDao.save(johnSmith);

            //When
            List<Employee> employees = searchFacade.findEmployeeByPartOfName("sm");

            //Then
            assertEquals("John", employees.get(0).getFirstname());
            assertEquals("Smith", employees.get(0).getLastname());
        } catch (SearchException e) {
            System.out.println(SearchException.ERR_EMPLOYEE_NOT_EXIST);
        } finally {
            //CleanUp
            employeeDao.deleteById(johnSmith.getId());
        }
    }
}