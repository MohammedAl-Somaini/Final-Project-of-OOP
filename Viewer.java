import javax.swing.text.View;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Viewer {
    Controller c;
    Scanner Me;

    public Viewer() throws FileNotFoundException {
        c =new Controller();
        Me =new Scanner(System.in);
    }
    public  void First() throws FileNotFoundException
    {
        System.out.println("   *******************************************  ");
        System.out.println("         Simple Pharmacy Cheat app       ");
        System.out.println("   *******************************************  ");
        while (true)
        {
            System.out.println("1: Add A New Drug \n "+"------------------------------\n"+"2: View All The drugs That Are In The Pharmacy\n"+
                    "------------------------------\n"+ "3: Search For Drug By Its ID\n"+"------------------------------\n"+" 4:Modify Description of a drug\n"
                    +"------------------------------\n"  +"5:Delete Data of A Drug\n"+"------------------------------\n"+" 0:To Exit\n\n");
            int choice=Me.nextInt();
            switch (choice)
            {
                case 1:add(); break;
                case 2:view(); break;
                case 3:find(); break;
                case 4:edit(); break;
                case 5:delete(); break;
                case 0:
                    c.writeDrugFile();
                    System.out.println("You Have Exited Thanks For Using This Program");
                    System.exit(0);
            }
        }
    }
    public void add()
    {
        System.out.println(" DrugId        DrugName        DrugDescription    DrugPrice");
        int Id=Me.nextInt();
        String DN=Me.next();
        String dDesc= Me.next();
        double DP=Me.nextDouble();
        boolean duplicted=c.checkForDuplication(new Drug(Id,DN,dDesc,DP));
        if (duplicted) System.out.println("there is a drug in the pharmacy with this drug");
        else {
        boolean added= c.addNewDrug(Id,DN,dDesc,DP);
        if (added)
            System.out.println("The Drug That You Entered IS Added");
        else
            System.out.println("Too Much drugs In the Pharmacy ");
    }}
    public void view()
    {
        Drug[]all=c.displayAllDrug();
        System.out.println("DrugId        DrugName      DrugDescription      DrugPrice");
        for (int i = 0; i < all.length; i++) {
           if(all[i]!=null)
               System.out.println(all[i].toString());
        }
    }
    public void find()
    {
        System.out.println("Write The ID of The Drug That You are searching for");
        int Id=Me.nextInt();
        Drug d= c.sreachForDrug(Id);
        if (d!=null)
        {
            System.out.println("DrugId        DrugName         DrugDescription         DrugPrice2 ");
            System.out.println(d.getDrugId()+"               "+d.getDrugName()+"            "
                    +d.getDrugDescription()+"          "+d.getDrugPrice());
        }
        else
            System.out.println("We do not Have A drug With this id");
    }
    public void edit()
    {
        System.out.println("Please Write The Id of The drug "+"That you Want To Modify Its Description");
        int index=Me.nextInt();
        System.out.println("Now Write The New Descrption");
        String NewDescription=Me.next();
        boolean edited=c.editDrugDesc(index,NewDescription);
        if (edited)
            System.out.println("The Description has Modified ");
        else System.out.println("There Is no Drug With This ID");
    }
    public void delete()
    {
        System.out.println("Please Write The Id of The drug "+"That you Want To Delete it");
        int i=Me.nextInt();
        boolean deleted=c.deleteDrugData(i);
        if (deleted)
            System.out.println("The drug with This ID is Deleted");
        else System.out.println("There Is no Drug With This ID");
    }
}
