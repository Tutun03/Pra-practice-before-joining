import java.util.*;

public class ipa_p4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Review> reviews = new ArrayList<Review>();
        Product p = new Product();
        System.out.print("Enter product name:");
        p.setProductName(sc.nextLine());
        System.out.print("Enter  price:");
        p.setPrice(sc.nextDouble());
        sc.nextLine();
        System.out.print("Enter category:");
        String g = sc.nextLine();
        p.setCategory(g);
        System.out.print("Enter number of reviews:");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("");
        for (int i = 0; i < n; i++) {
            System.out.println("Review " + (i + 1) + ":");
            System.out.print("Reviewer name:");
            String name = sc.nextLine();
            System.out.print("Enter rating:");
            double rating = sc.nextDouble();
            sc.nextLine();
            reviews.add(new Review(name, rating));
            System.out.println("");
        }
        p.setReviews(reviews);
        System.out.print("Enter the reviewer name to remove: ");
        String name = sc.nextLine();
        System.out.println("Product details before Removing Review");
        System.out.println("Product Name:" + p.getProductName());
        System.out.println("Price:" + p.getPrice());
        System.out.println("Category:" + p.getCategory());
        System.out.println("Reviews:");
        for (int i = 0; i < p.getReviews().size(); i++) {
            System.out.println("Reviewer: " + p.getReviews().get(i).getReviewerName() + ", " + "Rating: "
                    + p.getReviews().get(i).getRating());
        }
        System.out.println("");
        System.out.println("Product Details After Removing Review:");
        Product ans = removeReviewByReviewer(name, p);
        if (ans != null) {
            System.out.println("Product Name: " + ans.getProductName());
            System.out.println("Price: $" + ans.getPrice());
            System.out.println("Category: " + ans.getCategory());
            System.out.println("Reviews:");
            for (int i = 0; i < ans.getReviews().size(); i++) {
                System.out.println("Reviewer: " + ans.getReviews().get(i).getReviewerName() + ", " + "Rating: "
                        + ans.getReviews().get(i).getRating());
            }
        }
        HashMap<String, Double> map = calculateMinMaxRatings(p);
        double maxRating = Double.MIN_VALUE;
        Double minRating = Double.MAX_VALUE;
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (entry.getValue() > maxRating) {
                maxRating = entry.getValue();
            }
            if (entry.getValue() < minRating) {
                minRating = entry.getValue();
            }
        }
        System.out.println("Maximum rating: " + maxRating);
        System.out.println("Minimum rating:" + minRating);
        System.out.println("Average rating:" + (maxRating + minRating) / 2);

    }

    public static HashMap<String, Double> calculateMinMaxRatings(Product p) {

        HashMap<String, Double> map = new HashMap<>();
        for (int i = 0; i < p.getReviews().size(); i++) {
            map.put("Rating" + (i + 1), p.getReviews().get(i).getRating());
        }
        TreeMap<String, Double> sortedMap = new TreeMap<>(new Comparator<String>() {
            public int compare(String k1, String k2) {
                return Double.compare(map.get(k2), map.get(k1));
            }
        });
        sortedMap.putAll(map);
        HashMap<String, Double> map2 = new HashMap<>(sortedMap);
        return map2;
    }

    public static Product removeReviewByReviewer(String name, Product p) {
        int count = 0;
        for (int i = 0; i < p.getReviews().size(); i++) {
            if (p.getReviews().get(i).getReviewerName().equalsIgnoreCase(name)) {
                count++;
                p.getReviews().remove(i);
                System.out.println("Review removed successfully");
                break;
            }
        }
        if (count == 0) {
            return null;
        } else {
            return p;
        }
    }
}

class Product {
    private String productName;
    private double price;
    private String category;
    private ArrayList<Review> reviews;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

}

class Review {

    private String reviewerName;
    private double rating;

    public Review(String reviewerName, double rating) {
        this.reviewerName = reviewerName;
        this.rating = rating;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

}