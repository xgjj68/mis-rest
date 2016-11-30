package rest.service.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import rest.mybatis.dao.test.UserTMapper;
import rest.mybatis.model.test.UserT;
@RestController
public class Test {
	@Autowired
	private UserTMapper userTMapper;
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public UserT searchUserById(@RequestParam(value="userId",defaultValue="1") Integer userId){
		return userTMapper.selectByPrimaryKey(userId);
	}
	//Retrieve Single User
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserT> getUserT(@PathVariable("id") Integer id) {
        System.out.println("Fetching User with id " + id);
        UserT user = userTMapper.selectByPrimaryKey(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<UserT>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<UserT>(user, HttpStatus.OK);
    }
	//create Usert
	@RequestMapping(value="/insertUserT",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody UserT usert, UriComponentsBuilder ucBuilder) {
		if (getUserT(usert.getUserId()).getBody()!=null) {
            System.out.println("A User with name " + usert.getUserName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        userTMapper.insertSelective(usert); 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(usert.getUserId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	//delete user by id
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UserT> deleteUser(@PathVariable("id") Integer id) {
        System.out.println("Fetching & Deleting User with id " + id);
 
        UserT user = getUserT(id).getBody();
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<UserT>(HttpStatus.NOT_FOUND);
        } 
        userTMapper.deleteByPrimaryKey(id);
        return new ResponseEntity<UserT>(HttpStatus.NO_CONTENT);
    }
	//update a user
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserT> updateUser(@PathVariable("id") Integer id, @RequestBody UserT user) {
        System.out.println("Updating User " + id);
         
        UserT currentUser = getUserT(id).getBody();
         
        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<UserT>(HttpStatus.NOT_FOUND);
        }
 
        currentUser.setUserName("test");
        userTMapper.updateByPrimaryKeySelective(currentUser);
        return new ResponseEntity<UserT>(currentUser, HttpStatus.OK);
    }
	public int insertUserT(UserT usert){
		return userTMapper.insertSelective(usert);
	}
	public UserTMapper getUserTMapper() {
		return userTMapper;
	}
	public void setUserTMapper(UserTMapper userTMapper) {
		this.userTMapper = userTMapper;
	}
	
}
