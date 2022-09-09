package com.example.demo.Services;

import com.example.demo.Repositories.ClientRepo;
import com.example.demo.Repositories.userOrderRepo;
import com.example.demo.modells.ClientOrder;
import com.example.demo.modells.OrderInBox;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderService {

    private final userOrderRepo userOrderRepo;
    private final PostBoxService postBoxService;
    private final ClientRepo clientRepo;


    //package is arrived in the box
    public String OrderArrived(String unique) {

        Random pass = new Random();
        String boxPIN = String.valueOf(pass.nextInt(10000));
        Optional<ClientOrder> clientorder =  clientRepo.findByUniqueNumber(unique);
        if (postBoxService.CapacityChecker(clientorder.get().getChoosedPostBox())) {
            if (clientorder.get().getIsShipped() == false) {
                clientorder.get().setIsShipped(true);

                postBoxService.addiItem(clientorder.get().getChoosedPostBox());
                clientorder.get().setOrderInBox(
                    userOrderRepo.save(  new OrderInBox(
                               UUID.randomUUID().toString(),
                               LocalDateTime.now(),
                               LocalDateTime.now().plusDays(3),
                               boxPIN,
                               unique
                               ))
           );
        }else{throw new IllegalStateException("Already shipped");}
        }
        return boxPIN + " you can receive it until " + LocalDateTime.now().plusDays(3);}


    public String findTheNameofTheBox(String number) {
        Optional<ClientOrder> client =  clientRepo.findByUniqueNumber(number);
        return client.get().getChoosedPostBox();
    }


    //taking the package from the box
    public Optional<OrderInBox> findByPIN(String pin) {
        Optional<OrderInBox> userorder = userOrderRepo.findByPIN(pin);


           if (userorder.isPresent()) {
               if (userorder.get().getOrderReceived() == null) {
                   userOrderRepo.SetOrderRecieved(pin, LocalDateTime.now());
                    String phonenumber =  userorder.get().getPhonenumber();
                   postBoxService.removeItem(findTheNameofTheBox(phonenumber));
               }else{throw new IllegalStateException("Already received");}

           } else {throw new IllegalStateException("wrong PIN");}
        return userOrderRepo.findByPIN(pin) ;
    }


}






