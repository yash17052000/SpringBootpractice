package transactional_SpringBoot.Project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import transactional_SpringBoot.Project.Entity.User;
import transactional_SpringBoot.Project.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


  //  @Transactional(propagation = Propagation.NOT_SUPPORTED)

    @Transactional(rollbackFor = Exception.class)
    public void debit(Long userId, Double amount) throws Exception {
        User user = userRepository.findById(userId).orElseThrow();
        user.setBalance(user.getBalance() - amount);
        userRepository.save(user);
        throw new Exception("Something went wrong");

      //  1) //for checked excepion
//        try{
//
//
//
//            //throw new RuntimeException();
//        }
//        catch (Exception e){
//
//            System.out.println("i got this eror"+e);
//
//
//
//        }
//        user.setBalance(user.getBalance() - amount);
//        userRepository.save(user);
        //user.setBalance(user.getBalance() - amount);
//        userRepository.save(user);
       //System.out.println("transation completed");
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void credit(Long userId, Double amount) {
        User user = userRepository.findById(userId).orElseThrow();
        user.setBalance(user.getBalance() + amount);
        userRepository.save(user);
        int x=1/0;
        user.setBalance(user.getBalance() + amount);
        userRepository.save(user);
    }
}
