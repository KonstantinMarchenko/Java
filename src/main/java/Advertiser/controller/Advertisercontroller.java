package Advertiser.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Advertiser.Exceptions.ProductNotfoundException;
import Advertiser.model.Advertiser;
import Advertiser.service.AdvertiserService;

@RestController
public class Advertisercontroller {
	
   @Autowired
   AdvertiserService service;
  
   @GetMapping("/api/advertiser")
   public List<Advertiser> GetAdvertisers(){
	   return service.GetAdvertisersFromService();	   
   }
   
   @GetMapping(value = "/api/advertiser/{id}")
   public Advertiser GetAdvertiser(@PathVariable("id") int id){
	   return service.GetAdvertiserFromService(id);	   
   }
   
   @PostMapping("/api/advertiser")
   public void CreateAdvertiser(@RequestBody Advertiser advertiser) {
	   service.CreateAdvertiser(advertiser);
   }
   
   @RequestMapping(value = "/api/advertiser/{id}", method = RequestMethod.DELETE)
   public void DeleteAdvertiser(@PathVariable("id") int id) {
	  if (!service.DeleteAdvertiser(id)) throw new ProductNotfoundException();
   }
   
   @RequestMapping(value = "/api/advertiser", method = RequestMethod.PUT)
   public void UpdateAdvertiser(@RequestBody Advertiser advertiser) {
	   if (!service.UpdateAdvertiser(advertiser)) throw new ProductNotfoundException();	   
   }
   
   @GetMapping(value = "/api/advertiser/{id}/creditlimit")
   public boolean CheckCreditLimit(@PathVariable("id") int id) {
	   return service.CheckCreditLimit(id);
   }
}
