package com.example.demo.Services;

import com.example.demo.Froms.ClientForms;
import com.example.demo.Repositories.ClientRepo;
import com.example.demo.Repositories.PostBoxRepo;
import com.example.demo.modells.ClientOrder;
import lombok.AllArgsConstructor;
import org.hibernate.engine.spi.SessionLazyDelegator;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepo clientRepo;
    private final PostBoxService postBoxService;
    public void UserForm(ClientForms forms) {
        Random pass = new Random();
        String unique = String.valueOf(pass.nextInt(100000));
        ClientOrder client1 = new ClientOrder(
                forms.getFirstname(),
                forms.getLastname(),
                forms.getPhonenumber(),
                forms.getChoosedPostBox()
        );
        client1.setUniqueNumber(unique);
        String postboxname = client1.getChoosedPostBox();
        postBoxService.InComingPackage(postboxname);
        client1.setIsShipped(false);
        clientRepo.save(client1);
    }


    public void deleteByUnique(String unique) {
        Optional<ClientOrder> clientOrder = clientRepo.findByUniqueNumber(unique);
        clientRepo.deleteById(clientOrder.get().getId());
    }

    public List<ClientOrder> listallorder() {
        return clientRepo.findAll();
    }


}
