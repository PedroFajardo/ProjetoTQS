package CloudDomus;

import CloudDomus.Works;
import org.springframework.data.jpa.repository.JpaRepository;

interface WorkersRepository extends JpaRepository<Works, Long> {

}