import java.util.Objects;

public class Drug {
    private int drugId;
    private String drugName;
    private String drugDescription;
    private double drugPrice;
    public static  int drugCounter=0;

    public Drug(int drugId, String drugName, String drugDescription, double drugPrice) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.drugDescription = drugDescription;
        this.drugPrice = drugPrice;
    }

    public Drug(int drugId, String drugName, String drugDescription) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.drugDescription = drugDescription;
    }

    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugDescription() {
        return drugDescription;
    }

    public void setDrugDescription(String drugDescription) {
        this.drugDescription = drugDescription;
    }

    public double getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(double drugPrice) {
        this.drugPrice = drugPrice;
    }

    @Override
    public String toString() {
        return  drugId +
                " \t" + drugName +
                "\t" + drugDescription +
                "\t" + drugPrice + "\n"
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drug drug = (Drug) o;
        return drugId == drug.drugId && Double.compare(drug.drugPrice, drugPrice) == 0 && Objects.equals(drugName, drug.drugName) && Objects.equals(drugDescription, drug.drugDescription);
    }
}
