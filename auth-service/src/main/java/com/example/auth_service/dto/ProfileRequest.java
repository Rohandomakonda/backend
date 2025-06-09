package com.example.auth_service.dto;

import lombok.Data;

@Data
public class ProfileRequest {

        private long userid;
        private String name;
        private long selectedImage;

        // Constructor
        public ProfileRequest(long userid, String name, long selectedImage) {
            this.userid = userid;
            this.name = name;
            this.selectedImage = selectedImage;
        }

        // No-argument constructor (optional, if needed)
        public ProfileRequest() {
        }

        // Getters
        public long getUserid() {
            return userid;
        }

        public String getName() {
            return name;
        }

        public long getSelectedImage() {
            return selectedImage;
        }

        // Setters
        public void setUserid(long userid) {
            this.userid = userid;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSelectedImage(long selectedImage) {
            this.selectedImage = selectedImage;
        }


}
