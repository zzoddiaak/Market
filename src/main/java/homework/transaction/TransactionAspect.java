package homework.transaction;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import homework.connect.ConnectionHolder;

@Aspect
@Component
public class TransactionAspect {

    private final ConnectionHolder connectionHolder;

    @Autowired
    public TransactionAspect(ConnectionHolder connectionHolder) {
        this.connectionHolder = connectionHolder;
    }

    @Around("@annotation(Transaction)")
    public Object manageTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result;
        try {
            connectionHolder.openTransaction();
            result = joinPoint.proceed();
            connectionHolder.commitTransaction();
        } catch (RuntimeException e) {
            connectionHolder.rollbackTransaction();
            throw e;
        } finally {
            if (!connectionHolder.isTransactionOpen()) {
                connectionHolder.closeConnection();
            }
        }

        return result;
    }
}
