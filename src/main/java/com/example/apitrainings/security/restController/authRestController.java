package com.example.apitrainings.security.restController;

import com.example.apitrainings.security.entities.Rrole;
import com.example.apitrainings.security.entities.Uuser;
import com.example.apitrainings.security.securityConfig.SecurityConfig;
import com.example.apitrainings.security.service.AuthService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
public class authRestController {
    @Autowired
    private AuthService authService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private SecurityConfig securityConfig;

    public authRestController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/saveUser")
    public ResponseEntity<Uuser> saveUser(@RequestBody Uuser uuser) {
        return new ResponseEntity<Uuser>(authService.saveUuser(uuser), HttpStatus.OK);
    }

    @PostMapping("/saveRole")
    public ResponseEntity<Rrole> saveRole(@RequestBody Rrole rrole) {
        return new ResponseEntity<Rrole>(authService.saveRrole(rrole), HttpStatus.OK);
    }

    @PostMapping("/addRoleToUser")
    public ResponseEntity<Uuser> saveRole(@RequestBody AddRoleToUserForm addRoleToUserForm) {
        return new ResponseEntity<Uuser>(authService.addRoleToUser(addRoleToUserForm.user, addRoleToUserForm.role), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Uuser>> getAllUsers() {
        return new ResponseEntity<List<Uuser>>(authService.getAllUsers(), HttpStatus.OK);
    }


//    @PostMapping("/authenticate")
//    public  ResponseEntity<Jwt> authenticate(@RequestBody HttpServletRequest request){
//       return (ResponseEntity<Authentication>) authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getParameter("username"), request.getParameter("password")));
////        final UserDetails userDetails = securityConfig.userDetailsServiceBean().loadUserByUsername();
//
//    }

}

@Data
class AddRoleToUserForm {
    String user;
    String role;

}

