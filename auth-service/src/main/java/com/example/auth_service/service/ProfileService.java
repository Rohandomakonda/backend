package com.example.auth_service.service;

import com.example.auth_service.Model.Profile;
import com.example.auth_service.dto.ProfileRequest;
import com.example.auth_service.repo.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    ProfileRepo profilerepo;
    public Profile addprofile(ProfileRequest request) {
        Profile profile = new Profile();
        profile.setUser_id(request.getUserid());
        profile.setName(request.getName());
        profile.setAvatar(request.getSelectedImage());

       Profile savedprofile= profilerepo.save(profile);
        // Assuming ProfileResponse has a constructor or builder to convert from Profile
        return savedprofile;
    }

    public Profile edit(Long profileId, ProfileRequest request) {
        // 1. Find existing profile by id
        Optional<Profile> optionalProfile = profilerepo.findById(profileId);

        if (!optionalProfile.isPresent()) {
            // Handle not found case — throw exception or return null or custom response
            throw new RuntimeException("Profile not found with id: " + profileId);
        }

        Profile profile = optionalProfile.get();

        profile.setUser_id(request.getUserid());
        profile.setName(request.getName());
        profile.setAvatar(request.getSelectedImage());

        // 3. Save updated profile
        Profile updatedProfile = profilerepo.save(profile);

        // 4. Return a ProfileResponse (assuming constructor from Profile)
        return updatedProfile;
    }

    public List<Profile> getProfiles(Long userId) {
        // Fetch all profiles where user_id = userId
        return profilerepo.findByUserId(userId);
    }




}
