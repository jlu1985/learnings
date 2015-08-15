package jlu.restx.resources;

import javax.validation.constraints.NotNull;
import restx.WebException;
import restx.annotations.GET;
import restx.annotations.POST;
import restx.annotations.RestxResource;
import restx.factory.Component;
import restx.http.HttpStatus;

/**
 *
 * @author jialu
 */
@Component
@RestxResource
public class Error {

    @GET("/error/401")
    public String unauthorized() {
        throw new WebException(HttpStatus.UNAUTHORIZED);
    }

    @GET("/error/404")
    public String notFound() {
        throw new WebException(HttpStatus.NOT_FOUND);
    }

    @GET("/error/500")
    public String internalServerError() {
        throw new WebException(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @POST("/error/400")
    public ValidatedModel badRequest(ValidatedModel model) {
        //This call requires restx.validation package using annotation on model class
        return model;
    }

    public static class ValidatedModel {

        @NotNull
        private String value;

        public ValidatedModel setValue(String value) {
            this.value = value;
            return this;
        }

        public String getValue() {
            return value;
        }
    }
}
