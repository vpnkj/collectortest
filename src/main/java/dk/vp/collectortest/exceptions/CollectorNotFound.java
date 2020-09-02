package dk.vp.collectortest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CollectorNotFound extends RuntimeException {

    public CollectorNotFound(String isin) {
        super(String.format("The collector with ISIN: %s, does not exist in VP", isin));
    }
}
