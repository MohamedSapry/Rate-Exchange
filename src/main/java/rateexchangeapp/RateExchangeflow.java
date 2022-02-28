package rateexchangeapp;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface RateExchangeflow {

    @WorkflowMethod
    Double  getExchangeRate(Double amount);

}
