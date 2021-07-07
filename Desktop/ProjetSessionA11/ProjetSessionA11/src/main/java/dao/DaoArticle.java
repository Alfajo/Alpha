/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Connection.ConnectionManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeles.Article;

/**
 *
 * @author Utilisateur
 */
public class DaoArticle {
    private String dbURL = "jdbc:mysql://localhost:3306/world";
    private String dbUser = "Kahina";
    private String dbPass = "Kahina2021-2022";

    public Article get(int id) throws SQLException, IOException {
        
        //Se connecter à la BDD
        
        Connection con = ConnectionManager.ConnectionManager();
         
        Article article = null;
        String nomArticle;
        String descArticle;
        Blob photoArticle;
        InputStream inputStream;
        String base64Image;
        String sql = "SELECT * FROM articles WHERE artilces_id = ?";
        
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                article = new Article();
                nomArticle = result.getString("nomArticle");
                descArticle = result.getString("descArticle");
                photoArticle = result.getBlob("photo");

                inputStream = photoArticle.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();
                base64Image = Base64.getEncoder().encodeToString(imageBytes);

                inputStream.close();
                outputStream.close();

                article.setNomArticle(nomArticle);
                article.setDescriptionArticle(descArticle);
                article.setPhotoArticle(nomArticle);
            }

        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
            throw ex;
        }

        return article;
    }

    /*public void enregistrerContact(String firstName, String lastName, InputStream inputStream) {

        Connection conn = null; // connection to the database

        try {
            // connects to the database
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

            String sql = "INSERT INTO contacts (first_name, last_name, photo) values (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setBlob(3, inputStream);

            // sends the statement to the database server
            int row = statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DaoArticle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                // closes the database connection
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}*/
    
}