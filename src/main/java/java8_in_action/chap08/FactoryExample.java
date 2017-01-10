package java8_in_action.chap08;

public class FactoryExample {
//  public static void main(String[] args) {
//    Supplier<Product> loanSupplier = Loan::new;
//    Loan loan = loanSupplier.get();
//
//    final static Map<String, Supplier<Product>> map = new HashMap<>();
////    static {
////      map.put("loan", Loan::new);
////      map.put("stack", Stock::new);
////      map.put("bond", Bond::new);
////    };
//  }
}

//class ProductFactory {
//  public static Product createProduct(String name) {
//    switch(name) {
//      case "loan":
//        return new Loan();
//      case "stock":
//        return new Stock();
//      case "bond":
//        return new Bond();
//      default:
//        throw new RuntimeException("No such product " + name);
//    }
//  }
//
//  public static Product createProduct2(String name) {
//    Supplier<Product> p = map.get(name);
//    if(p != null) return p.get();
//    throw new IllegalArgumentException("No such product " + name);
//  }
//}
