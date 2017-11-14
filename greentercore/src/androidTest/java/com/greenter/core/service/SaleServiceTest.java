package com.greenter.core.service;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.greenter.core.callback.ApiDataRequest;
import com.greenter.core.model.Invoice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class SaleServiceTest {

    private static final String API_ENDPOINT = "http://greenterapp-quertium.1d35.starter-us-east-1.openshiftapps.com/api/v1";

    @Before
    public void init() {
        Context context = InstrumentationRegistry.getTargetContext();
        NetWorking.init(context, API_ENDPOINT);
    }

    @Test
    public void getList() throws Exception {
        SaleService service = new SaleService(new ApiDataRequest<List<Invoice>>() {
            @Override
            public void setApiResponse(List<Invoice> data) {
                assertTrue("Lista vacía",data.size() > 0);
            }
        });
        service.getList("20480072872");
    }
}
