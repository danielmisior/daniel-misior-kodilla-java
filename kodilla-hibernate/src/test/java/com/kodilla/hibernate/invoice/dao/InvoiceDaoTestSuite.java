package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private InvoiceDao invoiceDao;

    private static final String invoiceNumber = "03/02/2022/AGD92480";

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product bluePaint = new Product("Blue paint");
        Product sink = new Product("Sink");
        Item item = new Item(bluePaint, new BigDecimal(99.99), 2);
        Item item1 = new Item(sink, new BigDecimal(430.00), 1);
        Invoice invoice = new Invoice(invoiceNumber);

        bluePaint.getItems().add(item);
        sink.getItems().add(item1);

        invoice.getItems().add(item);
        invoice.getItems().add(item1);
        item.setInvoice(invoice);
        item.setInvoice(invoice);

        //When
        productDao.save(bluePaint);
        productDao.save(sink);
        invoiceDao.save(invoice);
        itemDao.save(item);
        itemDao.save(item1);
        //invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        //Then
        assertNotEquals(0, invoiceId);

        //CleanUp
        try {
            productDao.deleteAll();
            itemDao.deleteAll();
            invoiceDao.deleteAll();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
