package rateexchangeapp;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

public class RateExchangeWorker {
    public static void main(String[] args) {
        WorkflowServiceStubs service = WorkflowServiceStubs.newInstance();
        WorkflowClient client = WorkflowClient.newInstance(service);

        WorkerFactory factory = WorkerFactory.newInstance(client);
        Worker worker = factory.newWorker(Shared.CURRENCY_EXCHANGE_RATE);

        worker.registerWorkflowImplementationTypes(RateExchangeflowImpl.class);
        worker.registerActivitiesImplementations(new CurrencyImpl(), new exchangeCurrencyImpl());

        factory.start();
    }
}
