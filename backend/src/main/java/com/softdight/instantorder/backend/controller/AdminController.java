package com.softdight.instantorder.backend.controller;

import com.softdight.instantorder.backend.constants.ErrorConstants;
import com.softdight.instantorder.backend.constants.ResponseConstants;
import com.softdight.instantorder.backend.exception.types.InstantOrderException;
import com.softdight.instantorder.backend.helper.MailManager;
import com.softdight.instantorder.backend.model.Menu;
import com.softdight.instantorder.backend.model.StringResponse;
import com.softdight.instantorder.backend.model.User;
import com.softdight.instantorder.backend.service.MenuService;
import com.softdight.instantorder.backend.service.UserService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("menuService")
    private MenuService menuService;

    private static MailManager mailManager = new MailManager();

    @PutMapping("/user-update")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        User existUser = userService.findByUsername(user.getUsername());
        if (existUser != null && !existUser.getId().equals(user.getId())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/user-delete")
    public ResponseEntity<?> deleteUser(@RequestBody User user) {
        userService.deleteUser(user.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/user-all")
    public ResponseEntity<?> findAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/user-number")
    public ResponseEntity<?> numberOfUsers() {
        Long number = userService.numberOfUsers();
        StringResponse response = new StringResponse();
        response.setResponse(number.toString());
        //to return it, we will use String Response because long is not a suitable response for rest api
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/send-pdf-via-gmail")
    public ResponseEntity<?> sendPdfViaGmail(@ApiParam(example = "georgeo4567@gmail.com") @RequestParam String to,
                                             @ApiParam(example = "menuId") @RequestParam String menuId
                                             ) throws InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException {
        // TODO secure this endpoint via token

        Optional<Menu> menuResource = menuService.findById(menuId);

        if(menuResource.isEmpty()){
            throw new InstantOrderException(ErrorConstants.THIS_OBJECT_ID_IS_NOT_IN_DB);
        }

        mailManager.sendMenuViaEmail(to,menuResource.get(),"1");

        return new ResponseEntity<>(ResponseConstants.SUCCESS, HttpStatus.OK);
    }
}
