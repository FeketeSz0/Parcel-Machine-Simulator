package com.example.demo.Controllers;

import com.example.demo.Froms.ClientForms;
import com.example.demo.Services.ClientService;
import com.example.demo.Services.OrderService;
import com.example.demo.Services.PostBoxService;
import com.example.demo.modells.ClientOrder;
import com.example.demo.modells.OrderInBox;
import com.example.demo.modells.PostBox;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class TerminalControllers {

    private final OrderService orderService;
    private final PostBoxService postBoxService;
    private final ClientService clientService;

   //ENDUSER
    @GetMapping()
    public String testUser() {
        return "user tested";
    }

    @PostMapping("/form")
    public String OrderByEndUser(@RequestBody ClientForms forms) {
        clientService.UserForm(forms);
        return "the form has been submited";
    }

   @GetMapping("open/{PIN}")
   public String OpenByPIN (@PathVariable("PIN") String PIN) {
       orderService.findByPIN(PIN);
       return "box is opened with " + PIN;
   }


    //POSTMAN

    @GetMapping("/order/{number}")
    public String placeOrder(@PathVariable("number") String number) {
        return "Your PIN is " + orderService.OrderArrived(number);
    }

    @GetMapping("/order/test")
    public String testpostman() {
        return "postman tested";
    }



    //ADMIN

    @GetMapping("/admin/status")
    public List<PostBox> ListAllBox() {
        return postBoxService.listofboxes();
   }

    @GetMapping("/admin/allorder")
    public List<ClientOrder> ListAllOrder() {
        return clientService.listallorder();
    }

    @GetMapping("/admin/test")
    public String testadmin() {
        return "admin tested";
    }

    @DeleteMapping("admin/delete/{unique}")
    public String DeleteShipped(@PathVariable("unique") String unique) {
     clientService.deleteByUnique(unique);
     return "deleted";
    }









}
