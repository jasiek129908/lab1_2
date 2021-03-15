package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;

public class DrugInvoiceCalculator implements InvoiceCalculator {

    private Money net;
    private RequestItem item;

    public DrugInvoiceCalculator(Money net, RequestItem item) {
        this.net = net;
        this.item = item;
    }

    @Override
    public InvoiceLine calculate() {
        BigDecimal ratio = BigDecimal.valueOf(0.05);
        String desc = "5% (D)";
        Money taxValue = net.multiplyBy(ratio);
        return new InvoiceLine(item.getProductData(), item.getQuantity(), net, new Tax(taxValue, desc));
    }
}
