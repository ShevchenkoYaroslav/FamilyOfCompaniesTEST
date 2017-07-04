package net.valsorya94.FamilyOfCompaniesTEST.controller;

import net.valsorya94.FamilyOfCompaniesTEST.model.Company;
import net.valsorya94.FamilyOfCompaniesTEST.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Valsorya94 on 04.07.2017.
 */

@Controller
public class CompanyController {
    private CompanyService companyService;

    @Autowired(required = true)
    @Qualifier(value = "companyService")
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(value = "companies", method = RequestMethod.GET)
    public String listCompanies(Model model) {
        model.addAttribute("company", new Company());
        model.addAttribute("ListCompanies", this.companyService.listCompanies());

        return "companies";
    }

    @RequestMapping(value = "/companies/add", method = RequestMethod.POST)
    public String addCompany(@ModelAttribute("company") Company company) {
        if (company.getIdOfCompany() == 0) {
            this.companyService.addCompany(company);
        } else {
            this.companyService.updateCompany(company);
        }

        return "redirect:/companies";
    }

    @RequestMapping("/remove/{id}")
    public String removeCompany(@PathVariable("id") int id) {
        this.companyService.removeCompany(id);

        return "redirect:/companies";
    }

    @RequestMapping("edit/{id}")
    public String editCompany(@PathVariable("id") int id, Model model) {
        model.addAttribute("company", this.companyService.getCompanyById(id));
        model.addAttribute("listCompanies", this.companyService.listCompanies());

        return "companies";
    }

    @RequestMapping("companydata/{id}")
    public String companyData(@PathVariable("id") int id, Model model) {
        model.addAttribute("company", this.companyService.getCompanyById(id));

        return "companydata";
    }

}
