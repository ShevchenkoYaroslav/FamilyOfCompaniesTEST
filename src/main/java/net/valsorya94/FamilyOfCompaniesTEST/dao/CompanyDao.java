package net.valsorya94.FamilyOfCompaniesTEST.dao;

import java.util.List;

import net.valsorya94.FamilyOfCompaniesTEST.model.Company;

/**
 * Created by Valsorya94 on 03.07.2017.
 */

public interface CompanyDao {
    public void addCompany(Company company);

    public void updateCompany(Company company);

    public void removeCompany(int id);

    public Company getCompanyById(int id);

    public List<Company> listCompanies();
}
