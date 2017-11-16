package patterns.factory.method;

public class ProductorImp1 implements Productor {

    private ProductorImp1() {
    }

    @Override
    public void product() {
        System.out.println("product");
    }

    public static Factory factory = new Factory() {

        // static int i = 1;

        @Override
        public Productor getProductor() {
            return new ProductorImp1();
        }
    };

    public static void main(String[] args) {
        ProductorImp1.factory.getProductor().product();
    }
}
