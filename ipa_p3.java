import java.util.*;

public class ipa_p3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        ArrayList<Review> rp = new ArrayList<Review>();
        String a = sc.nextLine();
        String b = sc.nextLine();
        int c = sc.nextInt();
        sc.nextLine();
        Movie mv = new Movie(a,b,c);
        System.out.println("Enter the no of reviews:");
        int numReviews = sc.nextInt();
        sc.nextLine();
        System.out.println("");
        for (int i = 0; i < numReviews; i++) {
            System.out.println("Enter review " + (i + 1) + ":");
            String a1 = sc.nextLine();
            double b1 = sc.nextDouble();sc.nextLine();
            rp.add(new Review(a1, b1));
            System.out.println("");

        }
        mv.setTitle(a);
        mv.setGenre(b);
        mv.setDuration(c);
        mv.setReviews(rp);
        System.out.println("Enter the reviewer name to remove");
        String name = sc.nextLine();
        Movie ans = removeReviewByReviewer(name,mv);
        if (ans != null) {
            System.out.println("Title: " + ans.getTitle());
            System.out.println("Genre: " + ans.getGenre());
            System.out.println("Duration: " + ans.getDuration());
            System.out.println("Reviews:");
            for (int i = 0; i < ans.getReviews().size(); i++) {
                System.out.println("Reviewer: " + ans.getReviews().get(i).getReviewerName());
                System.out.println("Rating: " + ans.getReviews().get(i).getRating());
            }
        }
        double maxRating = Double.MIN_VALUE;
        Double minRating= Double.MAX_VALUE;
        HashMap<String, Double> ans1 = findMaxRatings(mv);
        for( Map.Entry<String, Double> entry : ans1.entrySet())
        {
            if(entry.getValue()>maxRating)
            {
                maxRating=entry.getValue();
            }
            if(entry.getValue()<minRating)
            {
                minRating=entry.getValue();
            }


        }
        System.out.println("Maxrating is"+maxRating);
        System.out.println("Minrating"+minRating);

    }
    public static HashMap<String, Double> findMaxRatings(Movie mv) {
        HashMap<String, Double> myMap = new HashMap<>();
        for(int i=0;i<mv.getReviews().size();i++)
        {
            myMap.put("rating"+(i+1),mv.getReviews().get(i).getRating());
        }
        TreeMap<String, Double> sortedMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String k1, String k2) {
                return Double.compare(myMap.get(k2), myMap.get(k1)); // Descending order
            }
        });

        sortedMap.putAll(myMap);
        
        HashMap<String, Double> finalMap = new HashMap<>(sortedMap);
        return finalMap;
    
    }
    public static Movie removeReviewByReviewer(String name,Movie mv) {
        {
            int count = 0;
            for (int i = 0; i < mv.getReviews().size(); i++) {
                if (mv.getReviews().get(i).getReviewerName().equalsIgnoreCase(name)) {
                    count++;
                    mv.getReviews().remove(i);
                    System.out.println("Review removed successfully");
                    break;
                }
    
            }
            if (count == 0) {
                return null;
            } else {
                return mv;
            }
        }
    
    }

}



class Movie {
    private String title;
    private String genre;
    private int duration;
    private ArrayList<Review> reviews;

    public Movie(String title, String genre, int duration)

    {

        this.title = title;
        this.genre = genre;
        this.duration = duration;
        reviews = new ArrayList<>();

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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