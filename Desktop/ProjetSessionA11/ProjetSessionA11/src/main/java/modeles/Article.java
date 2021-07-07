/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeles;

/**
 *
 * @author Utilisateur
 */
public class Article {
    
    //attributs
    private String nomArticle;
    private String descriptionArticle;
    private String photoArticle;
    private double prixArticle;
    private int quantiteStock;

    //constructeur par defaut
    public Article() {
    }

    //Constructeur avec parametre incluant qte
    public Article(String nomArticle, String descriptionArticle, String photoArticle, double prixArticle, int quantiteStock) {
        this.nomArticle = nomArticle;
        this.descriptionArticle = descriptionArticle;
        this.photoArticle = photoArticle;
        this.prixArticle = prixArticle;
        this.quantiteStock = quantiteStock;
    }

    //Constructeur avec parametre excluant qte
    public Article(String nomArticle, String descriptionArticle, String photoArticle, double prixArticle) {
        this.nomArticle = nomArticle;
        this.descriptionArticle = descriptionArticle;
        this.photoArticle = photoArticle;
        this.prixArticle = prixArticle;
    }

    //Getters and setters
    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public String getDescriptionArticle() {
        return descriptionArticle;
    }

    public void setDescriptionArticle(String descriptionArticle) {
        this.descriptionArticle = descriptionArticle;
    }

    public String getPhotoArticle() {
        return photoArticle;
    }

    public void setPhotoArticle(String photoArticle) {
        this.photoArticle = photoArticle;
    }

    public double getPrixArticle() {
        return prixArticle;
    }

    public void setPrixArticle(double prixArticle) {
        this.prixArticle = prixArticle;
    }

    public int getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    
    //toString()-----
    @Override
    public String toString() {
        return "Article{" + "nomArticle=" + nomArticle + ", descriptionArticle=" + descriptionArticle + ", photoArticle=" + photoArticle + ", prixArticle=" + prixArticle + ", quantiteStock=" + quantiteStock + '}';
    }
    
    
    
    }
