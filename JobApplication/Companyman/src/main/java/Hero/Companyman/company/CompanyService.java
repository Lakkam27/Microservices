package Hero.Companyman.company;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompany(Company company,long id );
    void createCompany(Company company);
    boolean deleteCompany(long id );
    Company getCompanyById(long id );

}
