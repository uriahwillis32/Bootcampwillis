package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yearup.data.ProfileDao;
import org.yearup.data.UserDao;
import org.yearup.models.Profile;
import org.yearup.models.User;

import java.security.Principal;

@RestController
@RequestMapping("/profile")
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class ProfileController
{
    private final ProfileDao profileDao;
    private final UserDao userDao;

    @Autowired
    public ProfileController(ProfileDao profileDao, UserDao userDao)
    {
        this.profileDao = profileDao;
        this.userDao = userDao;
    }

    // GET /profile
    @GetMapping
    public ResponseEntity<Profile> getProfile(Principal principal)
    {
        try
        {
            String username = principal.getName();
            User user = userDao.getByUserName(username);

            if (user == null)
            {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            Profile profile = profileDao.getByUserId(user.getId());

            if (profile == null)
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            return ResponseEntity.ok(profile);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // PUT /profile
    @PutMapping
    public ResponseEntity<Void> updateProfile(@RequestBody Profile profile, Principal principal)
    {
        try
        {
            String username = principal.getName();
            User user = userDao.getByUserName(username);

            if (user == null)
            {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            profileDao.update(user.getId(), profile);
            return ResponseEntity.noContent().build(); // 204 No Content
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // POST /profile
    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile, Principal principal)
    {
        try
        {
            String username = principal.getName();
            User user = userDao.getByUserName(username);

            if (user == null)
            {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            profile.setUserId(user.getId());
            Profile createdProfile = profileDao.create(profile);

            return ResponseEntity.status(HttpStatus.CREATED).body(createdProfile); // 201 Created
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}




