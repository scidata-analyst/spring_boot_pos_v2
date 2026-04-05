package com.scidata_analyst.pos.repository.user;

import com.scidata_analyst.pos.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Page<User> findByIsActiveTrue(Pageable pageable);

    @Query("SELECT u FROM User u WHERE " +
           "(:keyword IS NULL OR u.username LIKE %:keyword% OR u.firstName LIKE %:keyword% OR u.lastName LIKE %:keyword% OR u.email LIKE %:keyword%) AND " +
           "(:email IS NULL OR u.email = :email) AND " +
           "(:isActive IS NULL OR u.isActive = :isActive)")
    Page<User> searchUsers(@Param("keyword") String keyword,
                           @Param("email") String email,
                           @Param("isActive") Boolean isActive,
                           Pageable pageable);
}
