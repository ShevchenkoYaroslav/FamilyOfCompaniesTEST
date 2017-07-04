package net.valsorya94.FamilyOfCompaniesTEST.service;

import net.valsorya94.FamilyOfCompaniesTEST.dao.CompanyDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import net.valsorya94.FamilyOfCompaniesTEST.model.Company;

/**
 * Created by Valsorya94 on 03.07.2017.
 */

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyDao companyDao;

    public void setCompanyDao(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Transactional
    public void addCompany(Company company) {
        this.companyDao.addCompany(company);
    }

    @Transactional
    public void updateCompany(Company company) {
        this.companyDao.updateCompany(company);
    }

    @Transactional
    public void removeCompany(int id) {
        this.companyDao.removeCompany(id);
    }

    @Transactional
    public Company getCompanyById(int id) {
        return this.companyDao.getCompanyById(id);
    }

    @Transactional
    public List<Company> listCompanies() {
        return this.companyDao.listCompanies();
    }
}
