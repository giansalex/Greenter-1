package com.example.greenter_core;

import com.example.greenter_core.model.Invoice;

import java.util.List;

/**
 * Created by LENOVO on 11/11/2017.
 */

public interface callbackService {
    void getList(List<Invoice> invoiceList);
}
