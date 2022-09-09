package com.example.demo.modells;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;
@Data
@Entity
@NoArgsConstructor
public class OrderInBox {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String OrderNumber;
    private LocalDateTime orderPlaced;
    private LocalDateTime orderExpired;
    @Column(updatable = false)
    private LocalDateTime orderReceived;

    private String Phonenumber;
    private String PIN;

    public OrderInBox(String orderNumber, LocalDateTime orderPlaced, LocalDateTime orderExpired, String PIN, String Phonenumber)  {
        OrderNumber = orderNumber;
        this.orderPlaced = orderPlaced;
        this.orderExpired = orderExpired;
        this.PIN = PIN;
        this.Phonenumber = Phonenumber;
    }


}
