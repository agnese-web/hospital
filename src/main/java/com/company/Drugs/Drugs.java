package com.company.Drugs;

import com.company.Db.DbConn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

    public class Drugs {

      int id, given;
      String name, forwhat;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getForwhat() {
            return forwhat;
        }

        public void setForwhat(String forwhat) {
            this.forwhat = forwhat;
        }

        public int getGiven() {
            return given;
        }

        public void setGiven(int given) {
            this.given = given;
        }
    }

