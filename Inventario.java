import java.util.*;

class Inventario{
    private static ArrayList<Product> arr = new ArrayList<Product>();


    public static void menu(){
        System.out.println("/////////////////// \n");
        System.out.println("1. Aggiungi prodotto ");
        System.out.println("2. Visualizza prodotti ");
        System.out.println("3. Cerca prodotto per nome ");
        System.out.println("4. Elimina prodotto ");
        System.out.println("5. Filtra per prezzo ");
        System.out.println("6. Modifica");
        System.out.println("7. Esci \n");
    }

    public static void aggiungi(){
        Product nuovo;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Nome ");
        String nome = scanner.nextLine();
        System.out.println("2. Data ");
        String data = scanner.nextLine();
        System.out.println("3. Prezzo ");
        int prezzo = scanner.nextInt();
        nuovo = new Product(nome,data,prezzo);
        arr.add(nuovo);
    }

    public static String serachByName(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cerca (nome): ");
        String nome = scanner.nextLine();
        for (Product prodotto : arr) {
            if(prodotto.getName().equals(nome)){
                return prodotto.toString();
            }
        }
        return "Not found";
    }

    public static void deleteByName(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Rimuovi (nome): ");
        String nome = scanner.nextLine();
        for (Product prodotto : arr) {
            if(prodotto.getName().equals(nome)){
                arr.remove(prodotto);
                break;
            }
        }
    }

    public static void filterPrice(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Filtra perzzo per (1,2): ");
        System.out.println("1. Crescente: ");
        System.out.println("2. Decrescente: ");
        System.out.print("Input:");
        int input = scanner.nextInt();

        if(input == 1){
            arr.sort((a, b) -> Integer.compare(a.getPrice(), b.getPrice()));
        }else if(input == 2){
            arr.sort((a, b) -> Integer.compare(b.getPrice(), a.getPrice()));
        }else{
            System.out.println("Input invalido");

        }
        
    }

    public static void modifica(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Modifica (nome): ");
        String nome = scanner.nextLine();
        for (Product prodotto : arr) {
            if(prodotto.getName().equals(nome)){
                System.out.print("New nome: ");
                String name = scanner.nextLine();
                System.out.print("New date: ");
                String date = scanner.nextLine();
                System.out.print("New price: ");
                int price = scanner.nextInt();
                prodotto.setName(name);
                prodotto.setDate(date);
                prodotto.setPrice(price);
                break;
            }
        }
    }

    public static void main(String[] args) {
        boolean continua = true;
        Product a,b,c;
        a = new Product("Iphone", "29/02/2092", 999);
        b = new Product("Tablet", "21/02/2092", 799);
        c = new Product("GamingPc", "2/02/2092", 3000);
        arr.add(a);
        arr.add(b);
        arr.add(c);

       
        while (continua){
            menu();
            System.out.print("Input: ");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
    
            switch (input) {
                case 1: 
                    aggiungi();
                    break;
                case 2:
                    for (Product prodotto : arr) {
                        System.out.println("Prodotti \n");
                        System.out.println(prodotto.toString());
                    }
                    break;
                case 3:
                    System.out.println(serachByName());
                    break;
                case 4:
                    deleteByName();
                    break;
                case 5:
                    filterPrice();
                    break;
                case 6:
                    modifica();
                    break;
                case 7:
                    continua = false;
                    break;
                default:
                    System.out.println("Errore riprova");
                    break;
            }
        }
       
    }
}