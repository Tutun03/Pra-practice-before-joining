import java.util.*;
public class ipa_p2 {
   public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    NavelVessel[] nv=new NavelVessel[4];
    for(int i=0;i<nv.length;i++)
    {
        int a=sc.nextInt();sc.nextLine();
        String b=sc.nextLine();
        int c=sc.nextInt();sc.nextLine();
        int d=sc.nextInt();sc.nextLine();
        String e=sc.nextLine();
        nv[i]=new NavelVessel(a,b,c,d,e);

    }
    int f=sc.nextInt();sc.nextLine();
    String g=sc.nextLine();
    int ans=findAvgVoyagesByPct(nv,f);
    if(ans==0)
    {
        System.out.println("No vessels have completed at least "+f+"% of their planned voyages.");

    }
    else{
        System.out.println(ans);
    }
    NavelVessel ans1=findVesselByGrade(nv,g);
    if(ans1==null)
    {
        System.out.println("No vessels have the specified grade: "+g+".");
    }
    else{
        System.out.println(ans1.getVesselName()+"%"+ans1.getClassification());
    }
    
   } 

   public static NavelVessel findVesselByGrade(NavelVessel[] nv, String g) 
    {
        
       for(int i=0;i<nv.length;i++)
       {
       
        if(nv[i].getPurpose().equalsIgnoreCase(g))
        {
         
            double percentage=((nv[i].getNoOfVoyagesCompleted()*100)/nv[i].getNoOfVoyagesPlanned());
            if(percentage==100)
            {
                nv[i].setClassification("star");
            }
            else if(percentage>=80&&percentage<=99)

            {
                 nv[i].setClassification("leader");
            }
            else if(percentage>=55&&percentage<=79)
            {
                 nv[i].setClassification("Inspirer");
            }
            else
            {
                nv[i].setClassification("Striver");
            }
            return nv[i];
        }
       }
       return null;
       
       
    }
   public static int findAvgVoyagesByPct(NavelVessel[] nv, int f) {
     int sum=0;
     int count=0;
     for(int i=0;i<nv.length;i++)
     {
        double percentage=((nv[i].getNoOfVoyagesCompleted()*100)/nv[i].getNoOfVoyagesPlanned());
        if(percentage>=f)
        {
            count++;
            sum+=nv[i].getNoOfVoyagesCompleted();
            
        }

     }
     if(count==0)
     {
        return 0;
     }
     else{
        return sum/count;
     }


}
}

class NavelVessel{
private int vesselld;
private String vesselName;
private int noOfVoyagesPlanned;
private int noOfVoyagesCompleted;
private String purpose;
private String classification; 
public NavelVessel(int vesselld, String vesselName, int noOfVoyagesPlanned, int noOfVoyagesCompleted, String purpose){
    this.vesselld=vesselld;
    this.vesselName=vesselName;
    this.noOfVoyagesPlanned=noOfVoyagesPlanned;
    this.noOfVoyagesCompleted=noOfVoyagesCompleted;
    this.purpose=purpose;
}

public String getClassification() {
    return classification;
}

public void setClassification(String classification) {
    this.classification = classification;
}
public int getVesselld() {
    return vesselld;
}
public void setVesselld(int vesselld) {
    this.vesselld = vesselld;
}
public String getVesselName() {
    return vesselName;
}
public void setVesselName(String vesselName) {
    this.vesselName = vesselName;
}
public int getNoOfVoyagesPlanned() {
    return noOfVoyagesPlanned;
}
public void setNoOfVoyagesPlanned(int noOfVoyagesPlanned) {
    this.noOfVoyagesPlanned = noOfVoyagesPlanned;
}
public int getNoOfVoyagesCompleted() {
    return noOfVoyagesCompleted;
}
public void setNoOfVoyagesCompleted(int noOfVoyagesCompleted) {
    this.noOfVoyagesCompleted = noOfVoyagesCompleted;
}
public String getPurpose() {
    return purpose;
}
public void setPurpose(String purpose) {
    this.purpose = purpose;
}



}
