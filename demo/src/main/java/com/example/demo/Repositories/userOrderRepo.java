package com.example.demo.Repositories;

import com.example.demo.modells.OrderInBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Transactional
@Repository
public interface userOrderRepo extends JpaRepository<OrderInBox, Long> {

    @Query("SELECT c FROM OrderInBox c WHERE c.PIN = ?1")
    Optional<OrderInBox> findByPIN(String PIN);

    @Query("SELECT c FROM OrderInBox c WHERE c.orderReceived = ?1")
    Optional<OrderInBox> findByOrderReceived(LocalDateTime Received);
    @Modifying
    @Query("UPDATE OrderInBox c " +
            "SET c.orderReceived = ?2 " +
            "WHERE c.PIN = ?1")
    int SetOrderRecieved(String pin, LocalDateTime now);

}
