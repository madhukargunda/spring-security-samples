package com.study.pattern.security.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.study.pattern.security.domain.AppUser;
import com.study.pattern.security.service.AppUserService;

public class AppUserController {
	
	@Autowired
	AppUserService appUserService;  //Service which will do all data retrieval/manipulation work
  
      
    //-------------------Retrieve All AppUsers--------------------------------------------------------
      
    @RequestMapping(value = "/appUser/", method = RequestMethod.GET)
    public ResponseEntity<List<AppUser>> listAllAppUsers() {
        List<AppUser> AppUsers = appUserService.findAllUsers();
        if(AppUsers.isEmpty()){
            return new ResponseEntity<List<AppUser>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<AppUser>>(AppUsers, HttpStatus.OK);
    }
  
  
    //-------------------Retrieve Single AppUser--------------------------------------------------------
      
    @RequestMapping(value = "/appUser/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<AppUser> getAppUser(@PathVariable("id") long id) {
        System.out.println("Fetching AppUser with id " + id);
        AppUser AppUser = appUserService.findById(id);
        if (AppUser == null) {
            System.out.println("AppUser with id " + id + " not found");
            return new ResponseEntity<AppUser>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AppUser>(AppUser, HttpStatus.OK);
    }
  
      
      
    //-------------------Create a AppUser--------------------------------------------------------
      
    @RequestMapping(value = "/appUser/", method = RequestMethod.POST)
    public ResponseEntity<Void> createAppUser(@RequestBody AppUser appUser, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating AppUser " + appUser.getUsername());
  
        if (appUserService.isUserExist(appUser)) {
            System.out.println("A AppUser with name " + appUser.getUsername() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
  
        appUserService.saveUser(appUser);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/AppUser/{id}").buildAndExpand(appUser.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
      
    //------------------- Update a AppUser --------------------------------------------------------
      
    @RequestMapping(value = "/appUser/{id}", method = RequestMethod.PUT)
    public ResponseEntity<AppUser> updateAppUser(@PathVariable("id") long id, @RequestBody AppUser appUser) {
        System.out.println("Updating AppUser " + id);
          
        AppUser currentAppUser = appUserService.findById(id);
          
        if (currentAppUser==null) {
            System.out.println("AppUser with id " + id + " not found");
            return new ResponseEntity<AppUser>(HttpStatus.NOT_FOUND);
        }
        currentAppUser.setUsername(appUser.getUsername());   
        appUserService.updateUser(currentAppUser);
        return new ResponseEntity<AppUser>(currentAppUser, HttpStatus.OK);
    }
  
    //------------------- Delete a AppUser --------------------------------------------------------
      
    @RequestMapping(value = "/appUser/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<AppUser> deleteAppUser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting AppUser with id " + id);
  
        AppUser AppUser = appUserService.findById(id);
        if (AppUser == null) {
            System.out.println("Unable to delete. AppUser with id " + id + " not found");
            return new ResponseEntity<AppUser>(HttpStatus.NOT_FOUND);
        }
  
        appUserService.deleteUserById(id);
        return new ResponseEntity<AppUser>(HttpStatus.NO_CONTENT);
    }
  
      
    //------------------- Delete All AppUsers --------------------------------------------------------
      
    @RequestMapping(value = "/appUser/", method = RequestMethod.DELETE)
    public ResponseEntity<AppUser> deleteAllAppUsers() {
        System.out.println("Deleting All AppUsers");
        appUserService.deleteAllUsers();
        return new ResponseEntity<AppUser>(HttpStatus.NO_CONTENT);
    }

}
