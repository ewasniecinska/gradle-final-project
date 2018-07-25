package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.popular.android.java_lib.JokeGenerator;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    @ApiMethod(name = "getRandomJoke")
    public MyBean getRandomJoke() {
        MyBean response = new MyBean();
        response.setData(new JokeGenerator().getJoke());
        return response;
    }

   @ApiMethod(name = "sayHi")
   public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData(name);
        return response;
   }

}
