package davidegiliberti.epicode_12_9_24.repositories;

import davidegiliberti.epicode_12_9_24.entities.Autore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoreRepository extends JpaRepository<Autore, Integer> {
}
