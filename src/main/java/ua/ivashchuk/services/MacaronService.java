package ua.ivashchuk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ivashchuk.dao.MacaronRepository;
import ua.ivashchuk.domains.Macaron;

import java.util.List;

@Service
public class MacaronService {


    private final MacaronRepository macaronRepository;

    @Autowired
    public MacaronService(MacaronRepository macaronRepository){
        this.macaronRepository = macaronRepository;
    }

    public Macaron save(Macaron macaron){
        return macaronRepository.save(macaron);
    }

    public List<Macaron> findAllMacaron(){
        return macaronRepository.findAll();
    }

    public Macaron findById(Integer id){
        return macaronRepository.getById(id);
    }

    public void delete(Macaron macaron){
        macaronRepository.delete(macaron);
    }

    public void update(Integer id, Macaron updatedMacaron){
        Macaron macaronToBeUpdated = findById(id);

        macaronToBeUpdated.setName(updatedMacaron.getName());
        macaronToBeUpdated.setDescription(updatedMacaron.getDescription());
        macaronToBeUpdated.setPrice(updatedMacaron.getPrice());

        macaronRepository.save(macaronToBeUpdated);
    }

}
