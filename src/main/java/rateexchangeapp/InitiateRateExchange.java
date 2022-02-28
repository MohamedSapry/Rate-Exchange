package rateexchangeapp;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class InitiateRateExchange {
    public static void main(String[] args) {
        WorkflowServiceStubs service = WorkflowServiceStubs.newInstance();
        // WorkflowClient can be used to start, signal, query, cancel, and terminate Workflows.
        WorkflowClient client = WorkflowClient.newInstance(service);
        WorkflowOptions options = WorkflowOptions.newBuilder().setTaskQueue(Shared.CURRENCY_EXCHANGE_RATE).build();
        RateExchangeflow rateExchangeflow = client.newWorkflowStub(RateExchangeflow.class, options);

        Double currencyToExchange = rateExchangeflow.getExchangeRate(10.1);
        System.out.println(currencyToExchange);
        System.exit(0);
    }
}
