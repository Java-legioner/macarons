package ua.ivashchuk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ivashchuk.dao.CupcakeRepository;
import ua.ivashchuk.domains.Cupcake;

import java.util.List;

@Service
public class CupcakeService {

    private final CupcakeRepository cupcakeRepository;

    @Autowired
    public CupcakeService(CupcakeRepository cupcakeRepository){
        this.cupcakeRepository = cupcakeRepository;
    }

    public Cupcake save(Cupcake cupcake){

        return cupcakeRepository.save(cupcake);
    }

    public List<Cupcake> findAllCupcakes(){
        return cupcakeRepository.findAll();
    }

    public Cupcake findById(Integer id){
        return cupcakeRepository.getById(id);
    }

    public void delete(Cupcake cupcake){
        cupcakeRepository.delete(cupcake);
    }

    public void update(Integer id, Cupcake cupcake){
        Cupcake updateCupcake = findById(id);

        updateCupcake.setName(cupcake.getName());
        updateCupcake.setDescription(cupcake.getDescription());
        updateCupcake.setPrice(cupcake.getPrice());

        cupcakeRepository.save(updateCupcake);
    }



}
