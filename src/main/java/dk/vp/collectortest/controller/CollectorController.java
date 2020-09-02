package dk.vp.collectortest.controller;


import com.fasterxml.jackson.annotation.JsonView;
import dk.vp.collectortest.Views.Views;
import dk.vp.collectortest.domain.CollectorModel;
import dk.vp.collectortest.exceptions.CollectorNotFound;
import dk.vp.collectortest.service.CollectorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping(value = "/api/collector")
public class CollectorController {

    private final CollectorService collectorService;

    public CollectorController(CollectorService collectorService) {
        this.collectorService = collectorService;
    }

    @GetMapping("/{isin}")
    @JsonView(value = Views.Query.class)
    public CollectorModel getCollector(@PathVariable("isin") @NotBlank String isin) {
        return collectorService.getCollector(isin) // getAccount(uuid)
                .orElseThrow(() -> new CollectorNotFound(isin));
    }

    @GetMapping
    @JsonView(value = Views.Query.class)
    public List<CollectorModel> getAllCollectors() {
        return collectorService.getAllCollectors();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    @JsonView(value = Views.Query.class)
    public CollectorModel createCollector(@RequestBody @Valid @NotNull CollectorModel collectorModel) {
        return collectorService.createCollector(collectorModel);
    }

    @DeleteMapping("/{isin}")
    public void deleteCollector(@PathVariable("isin") @NotBlank String isin) {
        collectorService.deleteCollector(isin);
    }
}
