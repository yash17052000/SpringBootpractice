package transactional_SpringBoot.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import transactional_SpringBoot.Project.Service.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService service;

    @PostMapping("/transfer")
    public String transfer(@RequestParam Long senderId,
                           @RequestParam Long receiverId,
                           @RequestParam Double amount) {
        try {
            service.transfer(senderId, receiverId, amount);
        } catch (Exception e) {
            return "Transfer failed: " + e.getMessage();
        }
        return "Transfer completed";
    }
}
