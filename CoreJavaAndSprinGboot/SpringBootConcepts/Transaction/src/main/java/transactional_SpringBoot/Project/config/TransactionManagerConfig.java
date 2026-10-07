package transactional_SpringBoot.Project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionStatus;

import jakarta.persistence.EntityManagerFactory;

@Configuration
public class TransactionManagerConfig {

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf) {
            @Override
            protected void doBegin(Object transaction, TransactionDefinition definition) {
                super.doBegin(transaction, definition);
                System.out.println("Txn Logger --> New Transaction Started (propagation="
                        + definition.getPropagationBehavior() + ") "
                        + "(name = " + definition.getName() + ")");
            }

            @Override
            protected void doCommit(DefaultTransactionStatus status) {
                super.doCommit(status);
                System.out.println("Txn Logger --> Transaction COMMITTED " + status);
            }

            @Override
            protected void doRollback(DefaultTransactionStatus status) {
                super.doRollback(status);
                System.out.println("Txn Logger --> Transaction ROLLED BACK " + status);
            }
        };
    }
}