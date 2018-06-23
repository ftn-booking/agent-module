package ftnbooking.agent.soap;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {

	ApplicationUser findByEmail(String email);
	Optional<ApplicationUser> findById(Long id);
	//ApplicationUser findByResetToken(String token);

}
