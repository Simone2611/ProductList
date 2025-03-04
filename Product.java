public class Product {
    private String name;
    private String date;
    private int price;
    

    public Product(){
        name = "";
        date = "";
        price = 0;
    }

    public Product(String name, String date, int price){
        this.name = name;
        this.date = date;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public String getDate(){
        return date;
    }

    public int getPrice(){
        return price;
    }

    public void setName(String nome){
        this.name = nome;
    }

    public void setDate(String data){
        this.date = data;
    }

    public void setPrice(int prezzo){
        this.price = prezzo;
    }

    public String toString(){
        return "--------- \n" + "Nome: " + this.name + "\nData: " + this.date + "\nPrezzo: " + this.price;
    }
}
