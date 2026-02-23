package org.sd.test.PracticeTC;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersResponse {

        @Data
    /*@Data is a Lombok shortcut annotation that generates common boilerplate for plain Java objects: getters
    for all fields, setters for all non‑final fields, toString(), equals() and hashCode() implementations,
    and a constructor for required fields.*/


    @JsonIgnoreProperties(ignoreUnknown = true)
    /*If incoming JSON contains extra fields such as nickname or metadata, they will be ignored during
    deserialization.*/

    public static class User {
            private int id;
            private String name;
            private String username;
            private String email;
            private Address address;
            private String phone;
            private String website;
            private Company company;
        }

    // 🔹 Address object
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;
    }

    // 🔹 Geo object
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Geo {
        private String lat;
        private String lng;
    }

    // 🔹 Company object
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Company {
        private String name;
        private String catchPhrase;
        private String bs;
    }

}
