package net.valsorya94.FamilyOfCompaniesTEST;

/**
 * Created by Valsorya94 on 04.07.2017.
 */

import net.valsorya94.FamilyOfCompaniesTEST.model.Company;
import net.valsorya94.FamilyOfCompaniesTEST.service.CompanyService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

//TODO need fix all

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:web/WEB-INF/dispatcher-servlet.xml")
public class AppTest {
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void simple() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"));
    }

    private static CompanyService service;

    @BeforeClass
    public static void setUp() throws Exception {
        service = new CompanyService() {
            public void addCompany(Company company) {

            }

            public void updateCompany(Company company) {

            }

            public void removeCompany(int id) {

            }

            public Company getCompanyById(int id) {
                return getCompanyById(id);
            }

            public List<Company> listCompanies() {
                return listCompanies();
            }
        };
    }

    @Test
    public void testGetCompany() throws Exception {
        Company company = service.getCompanyById(1);

        System.out.println(company);

        Assert.assertNotNull(company);
    }

}