package ua.ivashchuk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ivashchuk.dao.BucketRepository;
import ua.ivashchuk.domains.Bucket;

import java.util.List;

@Service
public class BucketService {

    private final BucketRepository bucketRepository;
    @Autowired
    public BucketService(BucketRepository bucketRepository){
        this.bucketRepository = bucketRepository;
    }

    public List<Bucket> getAll(){
        return bucketRepository.findAll();
    }

    public Bucket add(Bucket bucket){
        return bucketRepository.save(bucket);
    }

    public void delete(Bucket bucket){
        bucketRepository.delete(bucket);
    }

}
