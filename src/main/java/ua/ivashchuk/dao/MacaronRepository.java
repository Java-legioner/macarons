package ua.ivashchuk.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.ivashchuk.domains.Macaron;

@Repository
public interface MacaronRepository extends JpaRepository<Macaron, Integer> {
}
