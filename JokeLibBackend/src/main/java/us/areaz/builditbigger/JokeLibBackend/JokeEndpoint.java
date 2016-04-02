/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package us.areaz.builditbigger.JokeLibBackend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import areaz.us.jokeprovider.JokeProvider;

/** endpoint class we are exposing */
@Api(
  name = "jAPI",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "JokeLibBackend.builditbigger.areaz.us",
    ownerName = "JokeLibBackend.builditbigger.areaz.us",
    packagePath=""
  )
)
public class JokeEndpoint {

    @ApiMethod(name = "getJoke")
    public JokeBean getJoke() {
        JokeBean response = new JokeBean();
        response.setData(new JokeProvider().getJoke());
        return response;
    }

}
