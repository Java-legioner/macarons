package ua.ivashchuk.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.ivashchuk.domains.Cupcake;

@Repository
public interface CupcakeRepository extends JpaRepository<Cupcake, Integer> {
}
