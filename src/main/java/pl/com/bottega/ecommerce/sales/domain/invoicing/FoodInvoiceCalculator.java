package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;

public class FoodInvoiceCalculator implements InvoiceCalculator {

    private Money net;
    private RequestItem item;

    public FoodInvoiceCalculator(Money net, RequestItem item) {
        this.net = net;
        this.item = item;
    }

    @Override
    public InvoiceLine calculate() {
        BigDecimal ratio = BigDecimal.valueOf(0.07);
        String desc = "7% (F)";
        Money taxValue = net.multiplyBy(ratio);
        return new InvoiceLine(item.getProductData(), item.getQuantity(), net, new Tax(taxValue, desc));
    }
}
