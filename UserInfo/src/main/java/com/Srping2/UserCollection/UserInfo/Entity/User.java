package com.Srping2.UserCollection.UserInfo.Entity;

import org.springframework.data.annotation.Id;
import javax.persistence.*;
@Entity
@Table(name = "user_table")
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id; //primary key
        @Column (name = "first_name")
        private String FirstName;
        @Column (name = "last_name")
        private String LastName;
        @Column (name = "email")
        private String Email;
        @Column (name = "comment")
        private String PersonalComment;

        public long getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirstName() {
            return FirstName;
        }

        public void setFirstName(String firstName) {
            FirstName = firstName;
        }

        public String getLastName() {
            return LastName;
        }

        public void setLastName(String lastName) {
            LastName = lastName;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String email) {
            Email = email;
        }

        public String getPersonalComment() {
            return PersonalComment;
        }

        public void setPersonalComment(String personalComment) {
            PersonalComment = personalComment;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", FirstName='" + FirstName + '\'' +
                    ", LastName='" + LastName + '\'' +
                    ", Email='" + Email + '\'' +
                    ", PersonalComment='" + PersonalComment + '\'' +
                    '}';
        }
    }


