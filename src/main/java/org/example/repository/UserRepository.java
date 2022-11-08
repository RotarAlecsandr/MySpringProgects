package org.example.repository;

import org.example.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository


public interface UserRepository extends JpaRepository<User, Integer> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE User  u SET  u.id = :id WHERE u.lastName = :lastName")
    int updateLastNameById(@Param("id") Integer id, @Param("lastName") String lastName);

    @EntityGraph(attributePaths = "userAddress")
    List<User> findAllByUserAddress_House(Integer house);

}
