package com.example.demo.Repositories;

import com.example.demo.modells.PostBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostBoxRepo extends JpaRepository<PostBox, Long> {

    @Query("SELECT c FROM PostBox c WHERE c.name = ?1")
    Optional<PostBox> findByName(String name);


}
