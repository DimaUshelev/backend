package dmitry.ushelev.budget.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dmitry.ushelev.budget.model.Balance;
import dmitry.ushelev.budget.model.Operation;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;
import java.util.List;

@Projection(name = "debitCreditAmount", types = {Balance.class})
public interface BalanceDebitCreditAmount {
    @JsonIgnore
    List<Operation> getOperations();

    default BigDecimal getDebit() {
        return getOperations().stream().map(Operation::getDebit).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    default BigDecimal getCredit() {
        return getOperations().stream().map(Operation::getCredit).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    default BigDecimal getAmount() {
        return getDebit().subtract(getCredit());
    }
}
