package advertiser.controller;

import advertiser.exceptions.ProductNotfoundException;
import advertiser.model.Advertiser;
import advertiser.service.AdvertiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdvertiserController {

    @Autowired
    AdvertiserService service;

    @GetMapping("/api/advertiser")
    public List<Advertiser> getAdvertisers() {
        return service.getAdvertisersFromService();
    }

    @GetMapping(value = "/api/advertiser/{id}")
    public Advertiser getAdvertiser(@PathVariable("id") int id) {
        return service.getAdvertiserFromService(id);
    }

    @PostMapping("/api/advertiser")
    public void createAdvertiser(@RequestBody Advertiser advertiser) {
        service.createAdvertiser(advertiser);
    }

    @RequestMapping(value = "/api/advertiser/{id}", method = RequestMethod.DELETE)
    public void deleteAdvertiser(@PathVariable("id") int id) {
        if (!service.deleteAdvertiser(id)) throw new ProductNotfoundException();
    }

    @RequestMapping(value = "/api/advertiser", method = RequestMethod.PUT)
    public void updateAdvertiser(@RequestBody Advertiser advertiser) {
        if (!service.updateAdvertiser(advertiser)) throw new ProductNotfoundException();
    }

    @GetMapping(value = "/api/advertiser/{id}/creditlimit")
    public boolean checkCreditLimit(@PathVariable("id") int id) {
        return service.checkCreditLimit(id);
    }
}