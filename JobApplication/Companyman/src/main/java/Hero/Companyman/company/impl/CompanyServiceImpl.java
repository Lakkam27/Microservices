package Hero.Companyman.company.impl;

import Hero.Companyman.company.Company;
import Hero.Companyman.company.CompanyRepository;
import Hero.Companyman.company.CompanyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private long nextid=1l;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    @Transactional
    public boolean updateCompany(Company company, long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company companyToUpdate = companyOptional.get();
            companyToUpdate.setDescription(company.getDescription());
            companyToUpdate.setName(company.getName());
            companyRepository.save(companyToUpdate);
            return true;
        } else {
            return false;
        }
    }

    @Override
    @Transactional
    public void createCompany(Company company) {
        company.setId(nextid++);
        companyRepository.save(company);
    }

    @Override
    @Transactional
    public boolean deleteCompany(long id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Company getCompanyById(long id) {
        return companyRepository.findById(id).orElse(null);
    }
}
