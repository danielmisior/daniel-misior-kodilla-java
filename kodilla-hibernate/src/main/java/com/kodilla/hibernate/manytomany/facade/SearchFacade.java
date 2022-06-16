package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchFacade {

    private final static Logger LOGGER = LoggerFactory.getLogger(SearchFacade.class);

    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    @Autowired
    public SearchFacade(final CompanyDao companyDao, final EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public List<Company> findCompanyByPartOfName(String nameFragment) throws SearchException {
        nameFragment = '%' + nameFragment + '%';
        return companyDao.findCompanyByPartOfName(nameFragment);
    }

    public List<Employee> findEmployeeByPartOfName(String nameFragment) throws SearchException {
        nameFragment = '%' + nameFragment + '%';
        return employeeDao.findEmployeeByPartOfName(nameFragment);
    }
}
