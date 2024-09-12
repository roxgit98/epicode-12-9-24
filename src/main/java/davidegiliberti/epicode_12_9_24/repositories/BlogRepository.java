package davidegiliberti.epicode_12_9_24.repositories;

import davidegiliberti.epicode_12_9_24.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
