package transactional_SpringBoot.Project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WalletService {

    @Autowired
    private UserService userService;
    @Transactional
    public void transfer(Long senderId, Long receiverId, Double amount) throws Exception {
        userService.debit(senderId, amount);
     ///   userService.credit(receiverId, amount);
        System.out.println("transaxtion ened");
    }
}
