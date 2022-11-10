import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Controller {
    private Drug []allDrug;
    private int numOfDrug;

    public Controller() throws FileNotFoundException {
      allDrug=new Drug[50];
      numOfDrug=0;
      readDrugFile();
    }
    public  boolean addNewDrug(int drugId, String drugName, String drugDescription, double drugPrice)
    {
        if(numOfDrug<allDrug.length)
        {
            Drug d= new Drug( drugId,  drugName,  drugDescription, drugPrice);
            allDrug[numOfDrug]=d;
            numOfDrug++;
            Drug.drugCounter++;
            return true;
        } else
            return false;
    }
    public Drug[] displayAllDrug()
    {
        return allDrug;
    }
    public  Drug sreachForDrug(int drugId)
    {
        boolean found=false;
        int i=0;
        while (!found&&i<allDrug.length)
        {
            if (allDrug[i]!=null)
            {
                if (allDrug[i].getDrugId()==drugId)
                    found=true;
                else
                    i++;
            }
            else i++;

        }
        if (i<allDrug.length)
            return allDrug[i];
        else
            return null;
    }
    public boolean checkForDuplication(Drug d)
    {
        for (int i = 0; i < numOfDrug; i++) {
            if (allDrug[i].equals(d))
                return true;

        }
       return false;
    }
    public void readDrugFile() throws FileNotFoundException{
        Scanner Me=new Scanner(new File("D:\\Drug.txt"));
        while (Me.hasNext())
        {
            int Id=Me.nextInt();
            String DN=Me.next();
            String dDesc= Me.next();
            double DP=Me.nextDouble();
           addNewDrug(Id,DN,dDesc,DP);
        }
        Me.close();
    }
    public void writeDrugFile() throws FileNotFoundException{
        PrintWriter w=new PrintWriter(new File("D:\\Drug.txt"));
        for (int i = 0; i < numOfDrug-1 ; i++) {
            w.write(allDrug[i].getDrugId()+"            "+allDrug[i].getDrugName()+"             "
                    +allDrug[i].getDrugDescription()+"            "+allDrug[i].getDrugPrice()+"\n");

        }
        w.close();
    }
    public boolean  editDrugDesc(int drugId, String drugDescription)
    {
        int index= sreachForDrug(drugId).getDrugId();
        if (index!=-1)
        {
            allDrug[index].setDrugDescription(drugDescription);
            return  true;
        }
        else return false;
    }
    public boolean deleteDrugData( int drugId)
    {
        int i= sreachForDrug(drugId).getDrugId();
        if (i!=-1){
            allDrug[i]=null;
            return true;
        }
        else return false;
    }
}