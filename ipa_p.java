import java.util.*;

public class ipa_p {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Flowers fl[] = new Flowers[4];
        for (int i = 0; i < fl.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            int d = sc.nextInt();sc.nextLine();
            String e = sc.nextLine();
            fl[i] = new Flowers(a, b, c, d, e);
        }
        String f=sc.nextLine();
     int ans=findMinPriceByType(fl,f); 

     if(ans!=0)
     {
        System.out.println(ans);
    }
    else{
        System.out.println("No flowers found");
    }
    }
    public static int findMinPriceByType(Flowers[] fl, String type) {
      Flowers[] fl1=new Flowers[0];
      for(int i=0; i < fl.length; i++) {
        if(fl[i].getrating()>3 && fl[i].getType().equalsIgnoreCase(type))
        {
            fl1=Arrays.copyOf(fl1, fl1.length+1);
            fl1[fl1.length-1]=fl[i];
        }
        for(int j=0; j < fl1.length; j++)
        {
            for(int  k=j; k < fl1.length; k++)
            {
                if(fl1[j].getPrice()>fl1[k].getPrice())
                {
                    Flowers temp = fl1[j];
                    fl1[j] = fl1[k];
                    fl1[k] = temp;
                }
            }
        }

        
    }
    if(fl1.length==0)
        {
            return 0;
        }
        else{
            return fl1[0].getFlowerId();
        }
           
    }
    
}


class Flowers {
    private int flowerId;
    private String flowerName;
    private int price;
    private int rating;
    private String type;
   

    public Flowers(int flowerId, String flowerName, int price, int rating, String type) {
        this.flowerId = flowerId;
        this.flowerName = flowerName;
        this.price = price;
        this.rating = rating;
        this.type = type;
    }

    public int getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(int flowerId) {
        this.flowerId = flowerId;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getrating() {
        return rating;
    }

    public void setrating(int rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}