/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.lw07.bl;

/**
 *
 * @author Anna
 */
public class MedicineData {
    private String id = "";
    private String name = "";
    private String company = "";
    private String group = "";
    private String consistence = "";
    private String dosageId = "";
    private String dosageFrequency = "";
    private String dosageNumber = "";
    private String isAfterFood = "";
    private String packageId = "";
    private String packageType = "";
    private String packagePrice = "";
    private String numberPerPackage = "";
    
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getCompany(){
        return company;
    }
    public void setCompany(String company){
        this.company = company;
    }
    
    public String getGroup(){
        return group;
    }
    public void setGroup(String group){
        this.group = group;
    }
    
    public String getConsistence(){
        return consistence;
    }
    public void setConsistence(String consistence){
        this.consistence = consistence;
    }
    
    public String getDosageId(){
        return dosageId;
    }
    public void setDosageId(String dosageId){
        this.dosageId = dosageId;
    }
    
    public String getDosageFrequency(){
        return dosageFrequency;
    }
    public void setDosageFrequency(String dosageFrequency){
        this.dosageFrequency = dosageFrequency;
    }
    
    public String getDosageNumber(){
        return dosageNumber;
    }
    public void setDosageNumber(String dosageNumber){
        this.dosageNumber = dosageNumber;
    }
    
    public String getIsAfterFood(){
        return isAfterFood;
    }
    public void setIsAfterFood(String isAfterFood){
        this.isAfterFood = isAfterFood;
    }
    public String getPackageId(){
        return packageId;
    }
    public void setPackageId(String packageId){
        this.packageId = packageId;
    }
    public String getPackageType(){
        return packageType;
    }
    public void setPackageType(String packageType){
        this.packageType = packageType;
    }
    public String getPackagePrice(){
        return packagePrice;
    }
    public void setPackagePrice(String packagePrice){
        this.packagePrice = packagePrice;
    }
    public String getNumberPerPackage(){
        return numberPerPackage;
    }
    public void setNumberPerPackage(String numberPerPackage){
        this.numberPerPackage = numberPerPackage;
    }
}
