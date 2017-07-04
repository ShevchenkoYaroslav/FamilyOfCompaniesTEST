package net.valsorya94.FamilyOfCompaniesTEST.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

import net.valsorya94.FamilyOfCompaniesTEST.model.Company;

/**
 * Created by Valsorya94 on 03.07.2017.
 */

@Repository
public class CompanyDaoImpl implements CompanyDao {
    private static final Logger logger = LoggerFactory.getLogger(CompanyDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCompany(Company company) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(company);
        logger.info("Company successfully saved. Company details: " + company);
    }

    public void updateCompany(Company company) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(company);
        logger.info("Company successfully update. Company details: " + company);
    }

    public void removeCompany(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Company company = (Company) session.load(Company.class, new Integer(id));

        if (company != null) {
            session.delete(company);
        }
        logger.info("Company successfully removed. Company details: " + company);
    }

    public Company getCompanyById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Company company = (Company) session.load(Company.class, new Integer(id));
        logger.info("Company successfully loaded. Company details: " + company);

        return company;
    }

    @SuppressWarnings("unchecked")
    public List<Company> listCompanies() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Company> companyList = session.createQuery("from Company").list();

        for (Company company : companyList) {
            logger.info("Company list: " + company);
        }

        return companyList;
    }
}
