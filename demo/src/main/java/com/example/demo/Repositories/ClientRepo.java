package com.example.demo.Repositories;

import com.example.demo.modells.ClientOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepo extends JpaRepository<ClientOrder, Long> {


    Optional<ClientOrder> findByPhonenumber(String phone);

    @Query("SELECT c FROM ClientOrder c WHERE c.UniqueNumber = ?1")
    Optional<ClientOrder> findByUniqueNumber(String unique);


    @Query("SELECT c FROM ClientOrder c WHERE c.ChoosedPostBox = ?1")
    List<ClientOrder> findByChoosedBox(String box);
}
