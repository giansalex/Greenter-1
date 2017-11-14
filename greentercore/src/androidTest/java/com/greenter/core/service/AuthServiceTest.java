package com.greenter.core.service;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.greenter.core.callback.ApiDataRequest;
import com.greenter.core.model.AuthResponse;
import com.greenter.core.model.User;
import com.greenter.core.model.UserRegister;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class AuthServiceTest {
    private static final String API_ENDPOINT = "http://f8289596.ngrok.io/api/v1";
    private static final String TAG = AuthServiceTest.class.getSimpleName();
    private AuthService service;

    @Before
    public void init() {
        Context context = InstrumentationRegistry.getTargetContext();
        NetWorking.init(context, API_ENDPOINT);
        service = new AuthService(new ApiDataRequest<AuthResponse>() {
            @Override
            public void setApiResponse(AuthResponse data) {
                assertNotNull(data.getToken());
                assertTrue(data.getToken().length() > 10);
                Log.d(TAG, "Token : " + data.getToken());
            }
        });
    }

    @Test
    public void testRegister() throws Exception {
        UserRegister reg = new UserRegister();
        reg.setEmail("user@domain.com");
        reg.setPassword("123456");
        reg.setRepeatPassword("123456");

        service.register(reg);
    }


    @Test
    public void testLogin() throws Exception {
        User user = new User();
        user.setEmail("user@domain.com");
        user.setPassword("123456");

        service.login(user);
    }
}
