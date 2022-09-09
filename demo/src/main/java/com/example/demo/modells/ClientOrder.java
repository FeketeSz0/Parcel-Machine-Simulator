package com.example.demo.modells;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class ClientOrder {


    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    private String phonenumber;
    @NotNull
    private String ChoosedPostBox;

    private String UniqueNumber;

    private Boolean IsShipped;


    @ManyToOne
    @JoinColumn(name = "user_order_id")
    private OrderInBox orderInBox;

    public ClientOrder(String firstname, String lastname, String phonenumber, String choosedPostBox) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        ChoosedPostBox = choosedPostBox;
    }
}
